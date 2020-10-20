package seedu.duke;

public class GraphDrawing {

    GraphProperty graphProperty;

    public GraphDrawing(DayMap dayMap, int targetCalories, int days) {
        this.graphProperty = new GraphProperty(dayMap, targetCalories, days);
    }

    /**
     * Repeats character back to back.
     * @param character
     * @param size
     * @return
     */
    public String repeatCharacter(String character, int size) {
        String characterText = "";
        for (int i = 0 ; i < size; i++) {
            characterText += character;
        }
        return characterText;
    }

    /**
     * Generates the x_axis
     * @return x_axis String
     */
    public String generate_x_axis() {
        String x_axis_line = "|-+";
        for (int i = 0; i < graphProperty.Column - 1; i++) {
            x_axis_line += repeatCharacter("-", 5) + "+";
        }
        return x_axis_line;
    }

    /**
     * Gets the character size of a number.
     * @param number
     * @return character size of number
     */
    public int getSizeOfCharacters(int number) {
        int size = 0;
        while (number != 0) {
            number /= 10;
            size++;
        }
        return size;
    }



    public void drawGraph() {
        String drawing = "";
        int size = getSizeOfCharacters(graphProperty.max_calories);
        String space = repeatCharacter(" ", size);
        for(int i = graphProperty.ROW - 1; i >= 0; i--) {
            if (i == graphProperty.ROW - 1) {
                drawing += Integer.toString(graphProperty.max_calories);
            } else if (i == graphProperty.targetRow) {
                drawing += Integer.toString(graphProperty.targetCalories) + repeatCharacter(" ", Integer.toString(graphProperty.max_calories).length() - Integer.toString(graphProperty.targetCalories).length());
            } else if (i == 0) {
                drawing += Integer.toString(graphProperty.min_calories) + repeatCharacter(" ", Integer.toString(graphProperty.max_calories).length() - Integer.toString(graphProperty.min_calories).length());
            } else {
                drawing += space;
            }
            drawing += "|";
            for (int j = 0; j < graphProperty.Column; j++) {
                if (graphProperty.Table[i][j] == 0) {
                    drawing += repeatCharacter(" ", 3);
                }
                else if (graphProperty.Table[i][j] == 1) {
                    drawing += "| |";
                }
                else if (graphProperty.Table[i][j] == 2) {
                    drawing += "***";
                }
                else if (graphProperty.Table[i][j] == 3) {
                    drawing += "|*|";
                }
                else if (graphProperty.Table[i][j] == 4) {
                    drawing += "|-|";
                }
                if (i == graphProperty.targetRow) {
                    drawing += "***";
                } else {
                    drawing += "   ";
                }
            }
            drawing += "\n";
        }
        System.out.print(drawing);
        System.out.println(repeatCharacter(" ", size) + generate_x_axis() + "--");
        System.out.println(repeatCharacter(" ", size - 1) + " " + graphProperty.parseDate(graphProperty.keys));
        System.out.println(repeatCharacter(" ", size));
    }

}
