
jar=.:sikuli-api-1.0.2-standalone.jar
build:
	javac  -Xlint -d .  -cp $(jar)  *.java

run%:build
	java -cp $(jar) robot $(word 2, $(subst _, ,$@)) $(word 3, $(subst _, ,$@)) $(word 4, $(subst _, ,$@))

clean:
	rm -rf *.class
