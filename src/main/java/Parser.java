public class Parser {
    /** Parse input by space. */
    public String[] parse(String line) {
        return line.split("\\s+");
    }

    /** Check input validation. */
    public void checkValidation(String[] input) throws DukeException {
        if (input[0].equals("bye") || input[0].equals("list")) {
            if (input.length != 1) {
                throw new DukeException("One word only.");
            }
        } else if (input[0].equals("done") || input[0].equals("delete")) {
            if (input.length != 2) {
                throw new DukeException("Wrong format.");
            } else {
                try {
                    int  number = Integer.parseInt(input[1]);
                } catch (NumberFormatException e) {
                    throw new DukeException("Index of task must be an integer.");
                }
            }
        } else if (input[0].equals("todo")) {
            if (input.length == 1) {
                throw new DukeException("The description of a todo cannot be empty.");
            }
        } else if (input[0].equals("deadline")) {
            if (this.find(input,"/by") == -1) {
                throw new DukeException("Wrong format: no /by when creating deadline task.");
            }
        } else if (input[0].equals("event")) {
            if (this.find(input,"/at") == -1) {
                throw new DukeException("Wrong format: no /at when creating event task.");
            }
        } else if (input[0].equals("find")) {
            if (input.length != 2) {
                throw new DukeException("Please search exactly one keyword.");
            }
        } else {
            throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }

    /** Find keyword index.
     * @param key the keyword needs to be found out.
     */
    public int find(String[] input,String key) {
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    /** Extract description and time.
     * @param key the keyword to seperate description and time.
     */
    public String[] extract(String[] input,String key) throws DukeException {
        String[] detail = new String[5];
        if (key == null) {
            String s = input[1];
            for (int i = 2; i < input.length; i++) {
                s += " " + input[i];
            }
            detail[0] = s;
        } else {
            int breakpoint = this.find(input,key);
            if (1 >= breakpoint) {
                throw new DukeException("Description is missing.");
            } else if (breakpoint + 1 > input.length - 1) {
                throw new DukeException("Time is missing.");
            } else {
                String s = input[1];
                for (int i = 2; i <= breakpoint - 1; i++) {
                    s += " " + input[i];
                }
                detail[0] = s;
                s = input[breakpoint + 1];
                for (int i = breakpoint + 2; i <= input.length - 1; i++) {
                    s += " " + input[i];
                }
                detail[1] = s;
            }
        }
        return detail;
    }
}
