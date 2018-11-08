# **HTTP-File-Push-and-Pull**



Push and pull files from and to a webserver (PHP, HTML and Java)

## On Webserver:

Place files to */webroot/*

- [get.php](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/php/get.php)
- [upload.php](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/php/upload.php)
- [data (folder)](https://github.com/user9209/HTTP-File-Push-and-Pull/tree/master/php/data)

Place files to */webroot/data*

- [.auth.get.php](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/php/data/.auth.get.php)
- [.auth.upload.php](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/php/data/.auth.upload.php)
- [.htaccess](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/php/data/.htaccess)

Update content of

- [.auth.get.php](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/php/data/.auth.get.php)

- [.auth.upload.php](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/php/data/.auth.upload.php)

  Replace \<key1> and \<key2>

### To use the Webfrontend

Place file to */webroot/*

- [upload.html](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/html/upload.html)

## Java:

Upload a file ([demo.txt](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/java/demo.txt)) via Java:

- [HTTP_Upload.java](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/java/src/HTTP_Upload.java)

- [HTTP_Download.java](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/master/java/src/HTTP_Download.java)

  Update [url](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/66fd236341cfeb45744dab1d41e542c4a82cace7/java/src/HTTP_Upload.java#L16), [url](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/41cfc745d241659a5c32c745d1ccfcd9648aa399/java/src/HTTP_Download.java#L14) and [key](https://github.com/user9209/HTTP-File-Push-and-Pull/blob/41cfc745d241659a5c32c745d1ccfcd9648aa399/java/src/HTTP_Download.java#L25) first!

Required libs:

- [Apache HttpClient](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient)
- [Apache HttpCore](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore)
- [Apache Commons HttpClient](https://mvnrepository.com/artifact/commons-httpclient/commons-httpclient)
- [Apache Commons Logging](https://mvnrepository.com/artifact/commons-logging/commons-logging)
- [Apache Commons Codec](https://mvnrepository.com/artifact/commons-codec/commons-codec)
