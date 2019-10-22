
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;

public class PruebaAPI {

    public static void main(String... args) throws Exception {
        // Instantiates a client
        try (LanguageServiceClient language = LanguageServiceClient.create()) {

            // The text to analyze
            String text = "Pésimo servicio";
            Document doc = Document.newBuilder()
                    .setContent(text).setType(Type.PLAIN_TEXT).build();

            // Detects the sentiment of the text
            Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

            System.out.printf("Text: %s%n", text);

            System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
            
            if (sentiment.getScore() > 0.8) {
                System.out.println("Claramente Positivo");
            } else if (sentiment.getScore() > 0.1) {
                System.out.println("Positivo");
            } else if (sentiment.getScore() <= 0.1 && sentiment.getScore() > -0.1) {
                System.out.println("Neutral");
            } else if (sentiment.getScore() < -0.1 && sentiment.getScore() > -0.6) {
                System.out.println("Negativo");
            } else {
                System.out.println("Claramente Negativo");
            }
        }
    }

}
