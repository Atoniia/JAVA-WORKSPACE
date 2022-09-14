public class XML DB insert {
    public static void main(String[] args) {
    public class InsertXML {
        private static final String INSERT_SQL =  "INSERT INTO ATTACHMENT(FILENAME, MIMETYPE, CONTENT) values(?, ?, ?)";
    
        public void insert(File xmlFile) {
             PreparedStatement ps = null;
             Connection con = null;
             try {
                 ps = con.prepareStatement(INSERT_SQL);
                 ps.setString(1, xmlFile.getName());
                 ps.setString(2, getMimeType(xmlFile));
                 ps.setBinaryStream(3, new FileInputStream(xmlFile));
                 ps.executeUpdate();
             } catch (SQLException e) {
                 // CLOSE ps and con;
             } catch (FileNotFoundException e) {
                // CLOSE ps and con;
             } finally {
                 // CLOSE ps and con;
             }
         }
    
         public String getMimeType(File xmlFile) {
             String mimeType = null;
            try {
                InputStream is = new BufferedInputStream(new FileInputStream(xmlFile));
                mimeType = URLConnection.guessContentTypeFromStream(is);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return mimeType;
         }
    
         public static void main(String[] args) {
             InsertXML insertXML = new InsertXML();
             insertXML.insert(new File("D:\test.xml"));
         }
    }
    CREATE TABLE ATTACHMENT (
  FILENAME VARCHAR(45) NOT NULL,
  MIMETYPE VARCHAR(45) NOT NULL,
  CONTENT LONGBLOB NOT NULL
) 
}
}
