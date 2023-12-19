package com.example.comp336_proj2;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.StringTokenizer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {



    //    static VBox vbox = new VBox();
    static String modified_tf_Sources;
    static Pane pane2 = new Pane();

    static VBox vbImages = new VBox();
    static Pane pane3 = new Pane();
    static char[] lcs;//array of lighted LEDs

    static boolean done = false;

    static boolean done2 = false;
    //hufffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff
    public static int numOf_DifCharacters = 0;//huffCodeArraySize
    public static int numOf_TotalCharacters = 0;//huffCodeArraySize
    public static long orgSize = 0;
    public static String HEADER = "";

    public static HuffCode[] huffArr;

    public static String huffPath = "";
    public static String filepath= "";

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {
        primaryStage.setTitle("OsaidB_1203115");


        ///////////////////////////////////////////////////////////////////////////////////
//        VBox vbox = new VBox();
        pane2.getChildren().clear();
        vbImages.getChildren().clear();
//        pane2.getChildren().add(vbImages);
//        vbImages.getChildren().add(image);


        pane2.getChildren().add(vbImages);
//		pane2.getChildren().add(imageDup);

        Label title = new Label("OsaidB_1203115");
//		title.setStyle("-fx-background-color: gray");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 0));
        title.setPadding(new Insets(15));

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));

        Label choose = new Label(":");
        choose.setPadding(new Insets(15));
//

        ///////////////////////////////////////////////////////////////////////file chooser section
        //file chooser section
        Button btnCompress = new Button("Choose A File To Compress");
        btnCompress.setPrefWidth(440);
//        btnFileChooser.setMinWidth(440);
        btnCompress.setMinHeight(50);
        btnCompress.setStyle("-fx-background-color: #b5c2c7 ;-fx-font-size: 20px;-fx-font-weight: bold;");

        Button btnShowHeader = new Button("Show Header");
        btnShowHeader.setPrefWidth(440);
        btnShowHeader.setDisable(true);
//        btnFileChooser.setMinHeight(50);
        btnShowHeader.setStyle("-fx-font-size: 16px;-fx-font-weight: bold;");

        btnCompress.setOnAction(e -> {
            resetALL();

            btnShowHeader.setDisable(false);
            btnCompress.setDisable(true);

            //open file chooser
            FileChooser fc1 = new FileChooser();

            fc1.setTitle("Choose Path To Read Data From");

            // Set the initial directory
            File initialDirectory = new File("C:\\Users\\97059\\Desktop\\Testing Ground");
            fc1.setInitialDirectory(initialDirectory);

            File file1 = fc1.showOpenDialog(primaryStage);

            if (file1 != null) {
                System.out.println("Selected File: " + file1.getAbsolutePath());


                //read data from the file
                try {
                    int[] frequencyArr = readFile(file1);
                    buildHuff(frequencyArr);
                    buildTree();
                    outputFile(file1);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
//                createOutputFile();
//                buildHuff(frequencyArr);


                vbImages.getChildren().clear();
                pane2.getChildren().clear();



                pane2.getChildren().add(vbImages);



            } else {
                resetALL();
                btnCompress.setDisable(false);
                btnShowHeader.setDisable(true);
                System.out.println("No file selected.");
            }


        });

        btnShowHeader.setOnAction(e -> {


            //duplicate "calculate.setOmAction"
//            runIT();
            showPopupHeader();
            btnCompress.setDisable(false);
            btnShowHeader.setDisable(true);
        });

        VBox vbFileChooser = new VBox(btnCompress, btnShowHeader);
        vbFileChooser.setPadding(new Insets(20));
        vbFileChooser.setSpacing(30);
        vbFileChooser.setStyle("-fx-border-color: #9d7463; -fx-border-width: 2px;");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////manually section
        //manually section
        Button btnDe_Compress = new Button("Choose A File To Decompress");
        btnDe_Compress.setPrefWidth(440);
        btnDe_Compress.setMinHeight(50);
        btnDe_Compress.setStyle("-fx-background-color: #b5c2c7 ;-fx-font-size: 20px;-fx-font-weight: bold;");

        //////////lblSources




        VBox vbSources = new VBox();
        vbSources.setAlignment(Pos.TOP_LEFT);

        //////////lblLEDs


        VBox vbLEDs = new VBox();
        vbLEDs.setAlignment(Pos.TOP_LEFT);

        //////////btns

        Button reset = new Button("Reset");
        reset.setMinWidth(440);
        reset.setDisable(true);
        reset.setStyle("-fx-font-size: 16px;-fx-font-weight: bold;");

        VBox vbBTNS = new VBox(20, reset);
        vbBTNS.setAlignment(Pos.TOP_LEFT);

        btnDe_Compress.setOnAction(e -> {
            resetALL();
            btnCompress.setDisable(false);
            btnShowHeader.setDisable(true);


            btnDe_Compress.setDisable(true);


            resetALL();

//            btnShowHeader.setDisable(false);
            btnDe_Compress.setDisable(true);

            //open file chooser
            FileChooser fc1 = new FileChooser();

            fc1.setTitle("Choose Path To Read Data From");

            // Set the initial directory
            File initialDirectory = new File("C:\\Users\\97059\\Desktop\\Testing Ground");
            fc1.setInitialDirectory(initialDirectory);

            File file1 = fc1.showOpenDialog(primaryStage);

            if (file1 != null) {
                System.out.println("Selected File: " + file1.getAbsolutePath());


                //read data from the file


//                    int[] frequencyArr = readFile(file1);
//                    buildHuff(frequencyArr);
//                    buildTree();
//                    huffPath = outputFile(file1);


//                createOutputFile();
//                buildHuff(frequencyArr);


                vbImages.getChildren().clear();
                pane2.getChildren().clear();



                pane2.getChildren().add(vbImages);



            } else {
                resetALL();
                btnDe_Compress.setDisable(false);
//                btnShowHeader.setDisable(true);
                System.out.println("No file selected.");
            }



        });



        //summing up manually section
        VBox vbManually = new VBox(btnDe_Compress, vbSources, vbLEDs, vbBTNS);
        vbManually.setPadding(new Insets(20));
        vbManually.setSpacing(30);
        vbManually.setStyle("-fx-border-color: #9d7463; -fx-border-width: 2px;");

//        vbBtn.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////Result Section
        //Result Section
        Button resultsSec = new Button("Results");
        resultsSec.setDisable(true);
        resultsSec.setPrefWidth(480);
        resultsSec.setMinHeight(50);
        resultsSec.setStyle("-fx-background-color: #455954 ;-fx-opacity: 1;-fx-font-size: 20px;-fx-font-weight: bold;");

        Label lblPath = new Label("Shortest Path:");
        lblPath.setPadding(new Insets(20));
        // path.setMinHeight(200);

        HBox h3 = new HBox();
        h3.setAlignment(Pos.CENTER);

        Label lblDistance = new Label("Distance (in meters):");
        lblDistance.setPadding(new Insets(20));

        TextField distanceText = new TextField();

        HBox h4 = new HBox(lblDistance, distanceText);
        h4.setAlignment(Pos.CENTER);

        //summing up Result Section
        VBox vbResult = new VBox(resultsSec, h3);
//        vbResult.setPadding(new Insets(20));
        vbResult.setSpacing(30);
        vbResult.setStyle("-fx-border-color: #9d7463; -fx-border-width: 2px;");

//        vbBtn.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        //summing up the two sections ( file chooser & manually )
        VBox summing = new VBox(vbFileChooser, vbManually, vbResult);


        summing.setSpacing(100);


        VBox mix = new VBox(10, summing);                //1+2

        mix.setAlignment(Pos.CENTER);

        mix.setSpacing(50);

        pane3.getChildren().add(mix);


        HBox mainHbox = new HBox(pane2, pane3);
        mainHbox.setSpacing(30);
        mainHbox.setPadding(new Insets(30));
//        mainHbox.setPadding(new Insets(0, 0, 100, 100));
        mainHbox.setAlignment(Pos.CENTER);

        pane.setCenter(mainHbox);
        pane.setAlignment(mainHbox, Pos.CENTER);


        //Creating the scroll pane
        ScrollPane scroll = new ScrollPane();

        pane.setStyle("-fx-background-color: #565c5e;");
        pane.setMinWidth(1200);


        scroll.setContent(pane);


        scroll.setFitToWidth(true);
        scroll.setFitToHeight(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//        scroll.setFitToHeight(true);


//		scroll.setPrefSize(595, 200);

        //Setting content to the scroll pane

//		scroll.setContent(zoomPane);

        //Setting the stage
//		Group root = new Group();
//		root.getChildren().addAll(scroll);

        scroll.setStyle("-fx-background-color: #565c5e;");

        Scene scene = new Scene(scroll, 1200, 1000);


        scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());
//		pane.setStyle("-fx-background-color: black");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void resetALL() {

//
//        pane2.getChildren().clear();
////
//            tf_LEDs.clear();
//            tf_Sources.clear();
//
//            distanceText.setText("");
//
//            data.clear();
//            tableData.clear();
//
////            numOfPointChoice = 0;
//
//            pane2.getChildren().add(image);
        vbImages.getChildren().clear();
        pane2.getChildren().clear();

        vbImages.getChildren().clear();
//        distanceText.setText("");





        vbImages.getChildren().clear();
//        vbImages.getChildren().add(image);

        pane2.getChildren().clear();
//        pane2.getChildren().add(vbImages);
        pane2.getChildren().add(vbImages);

    }

    private void runIT() {

        algo();


    }




    private void addPins() {//oldddddddddddddddddddddddddddddddddddddddddddddddddddddd


    }

    public static void main(String[] args) {

        launch(args);
    }

    public static void lock() {
        try {

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public void algo() {// O(n) = (V(logV+E))
/////////////////////////////////////////////////////////////////////////////////////

//        char[] lcs = new char[index + 1];

    }

    public static String dashedLine(int k) {
        StringBuilder sb = new StringBuilder(150);
        for (int n = 0; n < k; ++n)
            sb.append('-');
        return sb.toString();
    }

    public static void lcs(int ledsSize, int sourcesSize) {
        int[][] L = new int[ledsSize + 1][sourcesSize + 1];     //to store the length of the LCS at each pair of indices (i, j),
        // where i is an index in string X and j is an index in string Y.
//        String m2 = LEDs;
        int nip = 0;

        // #Finding the count and storing the comparsion results
        for (int i = 0; i <= ledsSize; i++) {
            // #iterating through first string
            for (int j = 0; j <= sourcesSize; j++) {
                // #iterating through second string and comparing every letter with 'i'th letter of the first string
                if (i == 0 || j == 0) { // #if either i or j is 0, then comparison result is o and comparsion notation is "  "
                    L[i][j] = 0;
                    System.out.print("   " + L[i][j]);
                }


            }

            if (nip < ledsSize) {

            }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // #Constructing LCS
        int index = L[ledsSize][sourcesSize];
        int temp = index;

        lcs = new char[index + 1];/////////////////////////////////////////////////////////////lcs is array of lighted leds
        lcs[index] = '\u0000'; // Set the terminating character


    }


    private static boolean hasDuplicates(int[] array) {
        int[] temprr = array;
        Arrays.sort(temprr);

        for (int i = 0; i < temprr.length - 1; i++) {
            if (temprr[i] == temprr[i + 1]) {
                return true; // Duplicate found
            }
        }

        return false; // No duplicates found
    }

    public int[] readFile(File file) throws IOException {

         filepath = file.getPath();
        FileInputStream scan = new FileInputStream(filepath);

        orgSize = scan.available();
        // Reading the file as bytes
        byte[] arrayOfBytes = new byte[1024]; // Buffer to read file as bytes (up to 1024 bytes per time)

        //taking the first set of data (maximum of 1024 element):
//        numOf_BytesRead = scan.read(arrayOfBytes, 0, 1024);
        int numOf_BytesRead = scan.read(arrayOfBytes, 0, 1024);//to keep track of the number of bytes read in each iteration
        //0:starting index in the arrayOfBytes where the read data will be placed.
        //read method returns the actual number of bytes read
        //or -1 if the end of the file is reached.

        //this array is like hashing --> every index is connected to a specific character
        //so when we say index number 7
        //it's same as we are saying L (for example)
        int[] frequencyArr = new int[256]; // Array to store character frequencies //256 possible character

        //here (in character) we store the index that represent the wanted character:
        int characterIndex;//to store unsigned integer value of the current byte

        // Read the file in chunks of 1024 bytes
        while (numOf_BytesRead > 0) {//as long as this loop is running
            // --> that means that the file still got data inside it
            // waiting for it to be read
            // Process each byte in the arrayOfBytes

            for (int i = 0; i < numOf_BytesRead; i++) {


                //getting the number(Index) that represent a specific character
                characterIndex = arrayOfBytes[i] & 255; // Convert byte to unsigned integer
                //like: (i-th byte) AND (255)
                //result: if (i-th byte) is a negative value(-128 - -1) it will be positive unsigned
                //ex: -120 byte = 136 Unsigned Integer

                // Update character frequency
                frequencyArr[characterIndex]++;

                // Count the number of different characters in the file
                if (frequencyArr[characterIndex] == 1) {
                    //if =1 then (in previous line-->
                    // it was the first time that we see this character and store it)
                    numOf_DifCharacters++;
                }


            }
            //taking the next set of data if exist (maximum of 1024 element)
            //1024 after 1024
            numOf_BytesRead = scan.read(arrayOfBytes, 0, 1024);
        }
        //now All the file was read,
        //and the array (frequencyArray[]) was created, and the frequency of each Character was set
        //(with each index being considered as a Character, and each content representing the frequency of this Character).

        //additionally : The number of different characters has been calculated. (numOf_DifCharacters)

        //resetting arrayOfBytes for potential future reads:
        Arrays.fill(arrayOfBytes, (byte) 0);

        return frequencyArr;
    }

    public void buildHuff(int[] frequencyArr) {//creating huffArr
        // Shrink the original array, building the huffCodeArray


        huffArr = new HuffCode[numOf_DifCharacters]; // building the huffArr
        int j = 0;
        //for loop to delete any character that does not exist within the file to be compressed
        for (int i = 0; i < 256; i++) {//256-->the size of frequencyArr[i] (the number of possible characters)

            if (frequencyArr[i] != 0) {// !=0 -> then exist
                huffArr[j++] = new HuffCode((char) i, frequencyArr[i]);// Number of Frequency
                numOf_TotalCharacters += frequencyArr[i];
//                j++;
                frequencyArr[i] = 0;
            }
        }


    }

    private void buildTree() {
        if (numOf_DifCharacters > 1) {


            TreeNode[] arrDif_Char = new TreeNode[numOf_DifCharacters];// array of nodes in size of Dif Characters

            MinHeap heap = new MinHeap(numOf_DifCharacters + 10);//extra space to handle potential overflow

//            for (int i = 0; i < numOf_DifCharacters; i++) {
            for (int i = 0; i < numOf_DifCharacters; i++) {

                //                  TreeNode(   int frequency,          char treeChar    )
                arrDif_Char[i] = new TreeNode(huffArr[i].frequency, huffArr[i].huffChar);
                heap.insert(arrDif_Char[i]);
            }                                           // Add the character and its frequency in tree node m,, then
            // add the tree node to the heap

            for (int i = 1; i <= arrDif_Char.length - 1; i++) {
                TreeNode z = new TreeNode();

                //getting the smallest two elements
                TreeNode min = heap.extractMin();
                TreeNode secondMin = heap.extractMin();

                z.frequency = min.frequency + secondMin.frequency;
                z.left = min;
                z.right = secondMin;
                heap.insert(z);
            }                                // delete from heap and add a new tree node

            TreeNode[] heapArray = heap.getHeapArray();
            //passing the root of ( heap tree )
            //to method makeCodes(root, code);
            makeCodes(heapArray[1], "");


        } else if (numOf_DifCharacters == 1) {
            huffArr[0].huffCode = "1";
            huffArr[0].codeLength = 1;
        } else {
            System.out.println("Error at buildTree()");
        }
    }

    private void makeCodes(TreeNode currNode, String code) {
        //starting with root of heap, we search for the leaves
        //and compare each leaf with
        if (currNode.left == currNode.right && currNode.right == null) { //node currNode is a leaf node

            //node represents a character in the Huffman tree
            for (int i = 0; i < numOf_DifCharacters; i++) {

                if (huffArr[i].huffChar == currNode.treeChar) {

                    huffArr[i].huffCode = code;

                    huffArr[i].codeLength = code.length();
                }
            }
        } else {
            makeCodes(currNode.left, code + '0');
            makeCodes(currNode.right, code + '1');
        }
    }

    private void outputFile(File file) throws IOException {

        String[] arrOf_huffCodes = new String[256];

        for (int i = 0; i < numOf_DifCharacters; i++) {
            arrOf_huffCodes[(int) huffArr[i].huffChar] = huffArr[i].huffCode;
        }//every Index with every huffCode

        //File Output Setup:
        huffPath = new StringTokenizer(file.getAbsolutePath(), ".").nextToken() + ".huff";
        File f = new File(huffPath);
        // output = new FileOutputStream(outFileName);
        FileOutputStream output = new FileOutputStream(huffPath);
        byte[] outBuffer = new byte[1024];//to store the compressed data.
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*getting the data that will be placed in header:
        for example:

        -Original File          : data.txt
        -Size of Original File  : 5234 Byte

        -compressed data size   : 2000 Byte

        -Huffman Codes  :-
        Character \t    Code
        L     \t\t\t    0101

        -Header Size            \t: 20 Byte
        */

        HEADER = "";
        int size = 0;

        String description = "orgFile:orgSize:compSize";
        HEADER = HEADER + description;
        for (int i = 0; i < description.length(); i++) {
            outBuffer[size++] = (byte) description.charAt(i);
        }
        outBuffer[size++] = '\n';
        HEADER = HEADER + '\n';

        //Getting Name of Org File
        String orgFileName = file.getName();  //with extension
        HEADER = HEADER + orgFileName;
        for (int i = 0; i < orgFileName.length(); i++) {                            //orgFile
            outBuffer[size++] = (byte) orgFileName.charAt(i);
        }
        outBuffer[size++] = ':';
        HEADER = HEADER + ':';

        //Getting Size of Original File
        String strOrgSize = String.valueOf(orgSize);                                //orgSize
        HEADER = HEADER + strOrgSize;
        for (int i = 0; i < strOrgSize.length(); i++) {
            outBuffer[size++] = (byte) strOrgSize.charAt(i);
        }
        outBuffer[size++] = ':';
        HEADER = HEADER + ':';


        //Getting compressed data size
        for (int i = 0; i < String.valueOf(numOf_DifCharacters).length(); i++) {    //compSize
            outBuffer[size++] = (byte) String.valueOf(numOf_DifCharacters).charAt(i);
        }
        outBuffer[size++] = '\n';

        for (int i = 0; i < outBuffer.length; i++)
            outBuffer[i] = 0;

        size=0;

        //getting huff codes
        String temp = "";
        for (int k = 0; k < huffArr.length; k++) {
            temp = "";
            if ((int) huffArr[k].huffChar == 10 || (int) huffArr[k].huffChar == 9) {
                continue;
            }
            temp = temp + huffArr[k].huffChar + ":" + huffArr[k].huffCode+"\n";
            HEADER = HEADER + temp;


        }
        for (int i = 0; i < temp.length(); i++) {
            outBuffer[size++] = (byte) temp.charAt(i);
        }
//        outBuffer[size++] = '\n';
//        HEADER = HEADER + '\n';


        //getting Header Size
        long headerSize = output.getChannel().position();
        String strHeaderSize ="Header Size: "+String.valueOf(headerSize);
        HEADER = HEADER + strHeaderSize;
        for (int i = 0; i < strHeaderSize.length(); i++) {    //compSize
            outBuffer[size++] = (byte) strHeaderSize.charAt(i);
        }
        outBuffer[size++] = '\n';
        HEADER = HEADER + '\n';
        output.write(outBuffer, 0, size);

        //resetting buffer
        for (int i = 0; i < outBuffer.length; i++)
            outBuffer[i] = 0;

        output.close();
        compressFile( arrOf_huffCodes,outBuffer);
    }

    public static void compressFile(String[] arrOf_huffCodes, byte[] outBuffer) {
        int tracker = 0;
        try (FileInputStream input = new FileInputStream(filepath);
             FileOutputStream output = new FileOutputStream(huffPath)) {

            byte[] buffer = new byte[1024];
            int numOf_BytesRead = input.read(buffer, 0, 1024);

            while (numOf_BytesRead > 0) {

                for (int i = 0; i < numOf_BytesRead; i++) {
                    int index = buffer[i] & 0xFF;

                    String huffCode = arrOf_huffCodes[index];
//                    String huffCode = huffCodes[index];

                    for (int j = 0; j < arrOf_huffCodes[index].length(); j++) {

                        char ch = arrOf_huffCodes[index].charAt(j);


                        if (ch == '1')
                            outBuffer[tracker / 8] = (byte) (outBuffer[tracker / 8] | 1 << 7 - tracker % 8);
                        tracker++;

                        if (tracker / 8 == 1024) {
                            output.write(outBuffer);
                            for (int k = 0; k < outBuffer.length; k++)
                                outBuffer[k] = 0;
                            tracker = 0;
                        }
                    }
                }
                numOf_BytesRead = input.read(buffer, 0, 1024);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showErrorPopup(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.getDialogPane().setStyle("-fx-font-size: 20px;");

        // Show the alert in a pop-up window
        alert.showAndWait();
    }
    private void showPopupHeader() {
        // Create a new stage for the popup
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL); // Prevent interaction with the main stage while the popup is open
        popupStage.setTitle("Header");

        // Create a TextArea inside a ScrollPane
        TextArea textArea = new TextArea();
        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);

        textArea.setPadding(new Insets(20));
        textArea.setStyle("-fx-font-size: 25;");
        // Add content to the TextArea (you can replace this with your actual content)
        textArea.setText(HEADER);

        // Create a layout for the popup scene
        VBox popupLayout = new VBox(10);
        popupLayout.getChildren().addAll(scrollPane);

        // Create the popup scene
        Scene popupScene = new Scene(popupLayout, 1000, 1000);

        // Set the scene for the popup stage
        popupStage.setScene(popupScene);

        // Show the popup stage
        popupStage.showAndWait(); // Show and wait for it to be closed before returning to the main stage
    }
}
