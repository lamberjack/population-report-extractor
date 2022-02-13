# population-report-extractor
Extract a distribution report from an input users data and a municipalities data.

# Instructions
#### 1. Project is managed by Maven: run *mvn clean install* executes unit tests and produces a *target/user-extractor-1.0.0.jar*.
#### 2. Copy *user-extractor-1.0.0.jar* inside a directory with *municipality.csv* and *input-user.csv* file.
#### 3. Execute *java -jar user-extractor-1.0.0.jar municipality.csv input-user.csv* (parameters files is mandatory and their order is important!).
#### 4. The output report file (*report.csv*) will be produced and the name of the region with lowest female age will be printed on the console.

