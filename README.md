# AEM Scraper
The idea of this project is to be able to crawl the out of the box AEM API 
(e.g. localhost:4503/api/content/sites/mysite.json) and pull out the properties we care about, along with the content.

Specifically, the use case for this project is to put the data into Amazon S3 and then use the data with
Amazon Comprehend to train a model using custom classification.
## To Run

### IntelliJ:
Maven Projects > Execute Maven Goal > clean install

Run > Edit Configurations

Add a JAR Application
  * Select the `aem-scraper-1.0-SNAPSHOT-jar-with-dependencies.jar`
  * Under Program Arguments, put the full URL to the top level JSON file of the tree you wish to traverse
  
### Command Line
`mvn clean install`

`cd target/`

`java -jar aem-scraper-1.0-SNAPSHOT-jar-with-dependencies.jar <url to top level json> <s3 bucket name> 
<path to s3 file (not including the file name)> <file or bytes>`

Above, specify `file` if you want the program to generate a csv file on your local machine, otherwise specify `bytes`.

If you have previously generated a csv file and placed it into `./data.csv`, then you can run the program with the 
flag `-DonlySendToS3=true`.

#### Example:
`java -jar aem-scraper-1.0-SNAPSHOT-jar-with-dependencies.jar http://localhost:4503/api/content/site/us/en.json
 my-bucket /first/second/folder file`