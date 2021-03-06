    
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

![picture alt](https://github.com/PawelRozniecki/Simple-Search-Engine/blob/main/images/menuScreen.png)

3. You can select an option by entering a number  between 1 and 3 in the terminal
* Option 1 allows you to index the document. Here you will be be able to specify document ID and the content of the document
![picture alt](https://github.com/PawelRozniecki/Simple-Search-Engine/blob/main/images/indexingScreen.png)
- Option 2 allows you to perform a search query on a single word. You will be asked to type in the word you want to search  
      - The output will consist of document ID's in which the term can be found along and their corresponding td_idf scores
 ![picture alt](https://github.com/PawelRozniecki/Simple-Search-Engine/blob/main/images/searchingScreen.png)
* Option 3 Terminates the application 
 ![picture alt](https://github.com/PawelRozniecki/Simple-Search-Engine/blob/main/images/Exiting.png)\
 
 
 ## Testing
 
- Tests have been performed using JUnit
- Test coverage: 100% (7 out of 7 test passed)
 
 ### Answer to the question in the provided task
 
 There are 2 errors in the example:
 1. When entering a fox keyword , the output is in the wrong order. The output should be document 3, document 1. This is because document 3 has higher TF-IDF due to having less words in the document.
 2. The requirement was to output document Id's along with their corresponding TF-IDF scores. The example doesn't contain the scores

   





  
