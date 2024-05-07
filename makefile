# Compiler & Executor
JC				= javac
J				= java

# Directory
SOURCE_FOLDER 	= src
OUTPUT_FOLDER	= bin
PROGRAM_NAME	= MyWordladder
GUI_NAME		= WordLadderGUI

# Commands
run:
	@$(J) -cp $(OUTPUT_FOLDER) $(PROGRAM_NAME)
gui:
	@$(J) -cp $(OUTPUT_FOLDER) $(GUI_NAME)
build:
	@$(JC) -d $(OUTPUT_FOLDER) \
		$(SOURCE_FOLDER)/algo/util/Calculator.java \
		$(SOURCE_FOLDER)/algo/util/Validator.java \
		$(SOURCE_FOLDER)/algo/structs/Node.java \
		$(SOURCE_FOLDER)/algo/structs/Tree.java \
		$(SOURCE_FOLDER)/algo/Algorithm.java \
		$(SOURCE_FOLDER)/algo/UCS.java \
		$(SOURCE_FOLDER)/algo/AStar.java \
		$(SOURCE_FOLDER)/algo/GreedyBFS.java \
		$(SOURCE_FOLDER)/AlgorithmHandler.java \
		$(SOURCE_FOLDER)/MyWordladder.java \
		$(SOURCE_FOLDER)/WordLadderGUI.java