package shpp.mentor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class App {

    public static final Logger logger = LoggerFactory.getLogger(App.class);
    public static final String FILE_NAME = "myProp.properties";
    static FileInputStream input;
    public static void main(String[] args) throws IOException {
        try {
            Properties myProp = new Properties();
            input = new FileInputStream(FILE_NAME);
            myProp.load(input);
            double maxValue=Integer.MAX_VALUE;
            String dataType;
            dataType=System.getProperty("type") != null?System.getProperty("type"):"int";
            String arguments = myProp.getProperty("min") + ";" + myProp.getProperty("max") +
                    ";" + myProp.getProperty("ink");
            if  (arguments.contains(".") && (Objects.equals(dataType, "int") || Objects.equals(dataType, "byte"))){
                logger.error("Input data dont match type!");
            } else {
                    switch (dataType) {
                        case "double":
                            maxValue = Double.MAX_VALUE;
                            break;
                        case "long":
                            maxValue = Long.MAX_VALUE;
                            break;
                        case "short":
                            maxValue = Short.MAX_VALUE;
                            break;
                        case "byte":
                            maxValue = Byte.MAX_VALUE;
                            break;
                        case "float":
                            maxValue = Float.MAX_VALUE;
                            break;
                        default:
                    }
                    logger.info(multNumber(arguments, maxValue));
                }
        }catch (IOException e){
            logger.error(String.valueOf(e));
        }finally {
            input.close();
        }
    }

    public static String multNumber(String args,double maxValue) {
        String[] parts = args.split(";");
        StringBuilder result = new StringBuilder();
        logger.info("From "+parts[0]+"     to "+parts[1]+"    step "+parts[2]+"    data type "+
                System.getProperty("type")+"    Max value "+maxValue);
        logger.info("----------------------------------------------------------------------------------------------");
        String message;
        if(args.contains(".")) {
            double min = Double.parseDouble(parts[0]);
            double max = Double.parseDouble(parts[1]);
            double ink = Double.parseDouble(parts[2]);
            for (double j = min; j <= max; j += ink) {
                for (double i = min; i <= max; i += ink) {
                    result.append(j).append("*").append(i).append("=").append(Multy.MultyDouble(i, j) < maxValue ?
                            Multy.MultyDouble(i, j) : "*****").append("    ");
                }
                logger.info(String.valueOf(result));
                result = new StringBuilder();
            }
            message="Procedure successful";
        }else{
            long min = Long.parseLong(parts[0]);
            long max = Long.parseLong(parts[1]);
            long ink = Long.parseLong(parts[2]);
            for (long j = min; j <= max; j += ink) {
                for (long i = min; i <= max; i += ink) {
                    result.append(j).append("*").append(i).append("=").append(Multy.MultyLong(i, j) < maxValue ?
                            Multy.MultyLong(i, j) : "*****").append("    ");
                }
                logger.info(result.toString());
                result = new StringBuilder();
            }
            message="Procedure successful";
        }
        return message;
    }
}