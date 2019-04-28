Main: compil

.class: .java
	$(CC) .class

JAVAFILES = \
						Controller.class \
						EcranAccueil.class \
						Main.class \
						Meuble.class \
						
CC = javac


Controller.class: Controller.java
	$(CC) Controller.java

EcranAccueil.class: EcranAccueil.java
	$(CC) EcranAccueil.java

Main.class: Main.java
	$(CC) Main.java

Meuble.class: Meuble.java
	$(CC) Meuble.java


compil: $(JAVAFILES)

test: compil
	java -cp "/export/documents/mariadb-client.jar:." Main 

clean:
	rm -f $(JAVAFILES)
