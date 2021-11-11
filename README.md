    
# Simple-search-engine

Goal was to create a simple search engine in Java. The search engine should be implemented
as an inverted index that runs in memory and can return a result
list that is sorted by TF-IDF.

## Functional Requirements

 * be able to take in a list of documents
 * support searches for single terms in the document set
 * return a list of matching documents together with their TF-IDF score
 * support sorting by TF-IDF

## Non Functional Requirements 

* Use JDK 11
* Use Maven or Gradle
* project should build to a single jar file
* project should have a main method

## Building application 

To build the JAR file use the command:
```
mvn clean package
```
- Output JAR is going to be saved in target/ directory

To run the JAR app  use the command:

``` java -jar SimpleSearchEngine-1.0-SNAPSHOT-jar-with-dependencies.jar```

## HOW TO 

1. Run the jar file
2. Main menu with 3 options will show up
3. You can select an option by entering a number  between 1 and3 in the terminal
    *Option 1 allows you to index a document
   





  
