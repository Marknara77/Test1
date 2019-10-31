//a utility class called DuplicateCounter.
class DuplicateCounter
{
    //   The counts should be stored in an instance variable called wordCounter.
    Map<String, Integer> wordCounter = new HashMap<String, Integer> ();
    //   an instance method called count that takes a single parameter called dataFile (representing the path to a text file) and uses a Map of Strings to count how many times each word occurs in dataFile.
    public void count(String fileName) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader(fileName));
        String line1 = br1.readLine();
        while(line1 != null)
        {
            String temp[] = line1.split(" ");
            for(String s:temp)
            {
                if (!wordCounter.containsKey(s))
                {
                    wordCounter.put(s, 1);
                }
                else
                {
                    int count = wordCounter.get(s);
                    wordCounter.put(s, count + 1);
                }
            }
            line1 = br1.readLine();
        }

        br1.close();
    }
    //   Create an instance method called write that takes a single parameter called outputFile (representing the path to a text file) and writes the contents of wordCounter to the file pointed to by outputFile.
    public void write(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fileName);
        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            pw.println(entry.getKey()+" : "+entry.getValue());
        }
        pw.close();
    }
}
