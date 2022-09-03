package dev.noaln;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import dev.noaln.classes.Credential;
import org.yaml.snakeyaml.Yaml;

import java.io.File;

public class Main {

    private static Credential credFile = null;
    private static final Yaml yaml = new Yaml();

    public static void main(String[] args) {
        //TODO: Proper Logging Library Setup
        System.out.println("Loading Credentials.. ");
        try{
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory()); // jackson databind
            credFile = mapper.readValue(new File("credentials.yaml"), Credential.class);

            System.out.println("Canvas: "+credFile.getCanvasapitoken());
            System.out.println("Engage: "+credFile.getEngageapitoken());
            System.out.println("Discord: "+credFile.getDiscordapitoken());

        }
        catch (Exception E){
            E.printStackTrace();
        }
    }
}