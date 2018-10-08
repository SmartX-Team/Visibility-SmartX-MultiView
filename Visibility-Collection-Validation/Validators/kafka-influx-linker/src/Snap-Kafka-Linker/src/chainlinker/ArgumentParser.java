package chainlinker;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ArgumentParser {
	
	public static final String DEFAULT_CONFIG_FILE_URL = "/opt/snap-kafka-parser/.snap-kafka-parser";

	public static class ArgumentMap {
		private String configURL;
		
		public ArgumentMap() {
		}

		public String getConfigURL() {
			return configURL;
		}
	}
	
	private ArgumentParser() {
		// No, I will not let this class be instantiated.
	}

	public static ArgumentMap parseArg(String[] args) throws ParseException {
		ArgumentMap argMap = new ArgumentMap();
		
        Options options = new Options();
        options.addOption("c", true, "Configuration Filepath");
        
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			throw e;
		}		
		
        if(cmd.hasOption("c")) {
            argMap.configURL = cmd.getOptionValue("c");
        }
        else {
			// Default values
			argMap.configURL = DEFAULT_CONFIG_FILE_URL;
        }
        
        return argMap;
	}
}
