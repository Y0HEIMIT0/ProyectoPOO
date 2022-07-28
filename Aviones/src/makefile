JFLAGS = -g -encoding ISO8859_1

JC = javac --module-path "/home/alumnos/pablo.verap/javafx-sdk-18.0.1/lib" --add-modules javafx.controls --add-modules javafx.media

JVM = java --module-path "/home/alumnos/pablo.verap/javafx-sdk-18.0.1/lib" --add-modules javafx.controls --add-modules javafx.media 


.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
	$(JVM)$*

CLASSES = Aviones.java\
	ControlTower.java\
	ControlTowerView.java\
	Plane.java\
	PlaneEvent.java\
	PLaneState.java\
	PlaneView.java\

MAIN = Aviones

default: classes

classes:$(CLASSES:.java=.class)
	

run: $(MAIN).class 
	$(JVM) $(MAIN) 

clean:
	$(RM) *.class