import org.apache.http.HttpStatus;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HTTP_Upload {
    private static String url = "https://<domain>/upload.php?auth=<keyX>";

    public static void main(String[] args) throws FileNotFoundException {

        // file to upload
        File sendFile = new File("demo.txt");

        String httpInputName = "userfile";

        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(url);

        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        // add files
        Part[] parts = {
                new FilePart(httpInputName, sendFile)
        };

        // enctype="multipart/form-data"
        method.setRequestEntity(
                new MultipartRequestEntity(parts, method.getParams())
        );

        try {
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody(40960);

            // May fail if binaries are send by the server!
            String bodyString = new String(responseBody);

            if(bodyString.equals("true"))
            {
                System.out.println("Upload correct!");
            }
            else
            {
                System.out.println("Upload failed!\n" + bodyString);
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
