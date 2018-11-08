import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HTTP_Download {
    private static String url = "https://<domain>/get.php";

    public static void main(String[] args) {

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);

        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        method.setQueryString(new NameValuePair[] {
                new NameValuePair("auth", "<keyX>")
        });

        try {
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody(40960);

            if(responseBody == null || responseBody.length < 1)
            {
                System.out.println("Download failed!");
            }
            else
            {
                try {
                    Files.write(Paths.get("demo.down.raw"), responseBody);
                    System.out.println("Download correct!");
                }
                catch (IOException e)
                {
                    System.out.println("Download failed! Can not write data!");
                }
            }
        } catch (HttpException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Connection errors: " + e.getMessage());
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
    }
}
