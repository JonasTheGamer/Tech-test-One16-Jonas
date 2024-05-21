# Technical test One16
By Jonas Van der Reysen

## Description
The objective is to show all combinations of those words that together form a word of 6 characters. That combination must also be present in input.txt  
E.g.:
``` 
foobar  
fo  
obar
```
should result in the output:
```
fo+obar=foobar
```

## How to run
1. Clone the repository
2. Run the following command in the terminal:
```
java -jar SixLetterWordsApi.jar <input.txt> <wordLength> <minWordLength>
```
Where:
- input.txt is the file with the words (optional, default: src/main/resources/input.txt)
- 6 is the length of the word to be formed (optional, default: 6)
- 3 is the minimum length of the words to be combined (optional, default: 3)
