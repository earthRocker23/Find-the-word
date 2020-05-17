
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */

/**
 * Se auti tin class sxediazoume to gui tu app mas.
 */
public class gui extends JFrame{
    private String nickname;
    private Letter[][] array; 
    private JButton[][] letterButton;
    private Dashboard dashboard;
    private Arena ar;
    //constants for menu shortcuts
    private static final int kControlA = 65;
    private static final int kControlD = 68;
    private static final int kControlC = 67;
    private static final int kControlR = 82;
    private static final int kControlP = 80;
    private static final int kControlT = 84;
    private static final int kControlX = 88; 
    
    private Container pane;
    private JPanel gridPanel;
    private GridLayout grid;
    private JTextField deleteRowText;
    private JTextField ShuffleRowText;
    private JTextField deleteColText;
    private JTextField ShuffleColText;
    private JTextField SwapTextX1;
    private JTextField SwapTextY1;
    private JTextField SwapTextX2;
    private JTextField SwapTextY2;
    private MouseListener mouseListener = createMouseListener();;

    public gui() {
        //Setting up the JFrame
        super("Word Adventure");
        
        CuteGUI();
        
        setResizable(false);
        setSize(350,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JButton okButton = new JButton("OK");
        JTextField text = new JTextField("Dwste to nickname sas",13);
        pane = getContentPane();
        FlowLayout flo = new FlowLayout();
        
        //Setting up the radio Buttons
        JRadioButton button5x5 = new JRadioButton("5x5");
        button5x5.setMnemonic(KeyEvent.VK_B);
        button5x5.setActionCommand("5x5");
        button5x5.setSelected(true);
        
        JRadioButton button8x8 = new JRadioButton("8x8");
        button8x8.setMnemonic(KeyEvent.VK_B);
        button8x8.setActionCommand("8x8");
        
        JRadioButton button10x10 = new JRadioButton("10x10");
        button10x10.setMnemonic(KeyEvent.VK_B);
        button10x10.setActionCommand("10x10");
        
        ButtonGroup group = new ButtonGroup();//orizeis to group apo koympia kai patietai mono ena kathe fora
        group.add(button5x5);
        group.add(button8x8);
        group.add(button10x10);
        
        //Adding on Container
        pane.setLayout(flo);
        pane.add(text);
        pane.add(button5x5);
        pane.add(button8x8);
        pane.add(button10x10);
        pane.add(okButton);
        pack();
        
        //Otan clickaristei to JTextField to orizw me to "".
        text.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                text.setText("");
            }
        });
        
        //O user pataei to OK button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nickname = text.getText();
                if(text.getText().trim().isEmpty()){
                    JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "Dwste ena nickname", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(nickname.equalsIgnoreCase("Dwste to nickname sas"))
                        nickname = "Unknown";
                    String radioButtons = group.getSelection().getActionCommand();
                    System.out.println(radioButtons);
                    if(radioButtons != null && radioButtons.equalsIgnoreCase("5x5")) {
                        Dashboard5x5 ff = new Dashboard5x5(nickname, 0, 3, 0);
                        dashboard = ff;
                        ff.ShuffleTheWords();
        //                System.out.println(ff.getWordsToUse());
                        ff.FindLetter();
                        ar = new Arena(ff.GetArray(), ff);
                        ar.DisplayArray();
                        getContentPane().removeAll();
                        FixDashboard();
                    } 
                    else if(radioButtons != null && radioButtons.equalsIgnoreCase("8x8")) {
                        Dashboard8x8 ee = new Dashboard8x8(nickname, 0, 3, 0);
                        dashboard = ee;
                        ee.ShuffleTheWords();
                //        System.out.println(ee.getWordsToUSe());
                        ee.FindLetter();
                        ar = new Arena(ee.GetArray(), ee);
                        ar.DisplayArray();
                        getContentPane().removeAll();
                        FixDashboard();
                    } 
                    else if(radioButtons != null && radioButtons.equalsIgnoreCase("10x10")) {
                        Dashboard10x10 tt = new Dashboard10x10(nickname, 0, 3, 0);
                        dashboard = tt;
                        tt.ShuffleTheWords();
                //        System.out.println(tt.getWordsToUse());
                        tt.FindLetter();
                        ar = new Arena(tt.GetArray(), tt);
                        ar.DisplayArray();
                        getContentPane().removeAll();
                        FixDashboard();
                    }
                }
                
            }
        });
    }
    
    public void FixDashboard(){
        setTitle("Find The Word " + dashboard.getNickname());
        if(ar.getArray().length==5){
            setSize(350,500);
        }
        else if(ar.getArray().length==8){
            setSize(500,500);
        }
        else{
            setSize(600,500);
        }
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JButton checkButton = new JButton("Check");
        Container pane = getContentPane();
        FlowLayout flo = new FlowLayout();
        revalidate();
        repaint();
        pane.setLayout(flo);
        checkButton.addActionListener(CheckListener);
        pane.addMouseListener(mouseListener);
        
        //helped from: http://www.developer.com/net/vb/article.php/874351/A-Simple-Java-Drawing-Tool.htm
        //Add menu bar to our frame
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        Menu tools = new Menu("Tools");
        //now add menu items to these Menu objects
        menu.add(new MenuItem("New Game", new MenuShortcut(kControlR))).addActionListener(new WindowHandler());
        menu.add(new MenuItem("Exit", new MenuShortcut(kControlD))).addActionListener(new WindowHandler());

        tools.add(new MenuItem("About", new MenuShortcut(kControlA))).addActionListener(new WindowHandler());
        tools.add(new MenuItem("Help", new MenuShortcut(kControlT))).addActionListener(new WindowHandler());
        //add menus to menubar
        menuBar.add(menu);
        menuBar.add(tools);
        this.setMenuBar(menuBar);
        
        JButton deleteRowButton = new JButton("Delete Row");               deleteRowText = new JTextField(1);
        JButton ShuffleRowButton = new JButton("Shuffle Row");             ShuffleRowText = new JTextField(1);
        JButton deleteColButton = new JButton("Delete Column");            deleteColText = new JTextField(1);
        JButton ShuffleColButton = new JButton("Shuffle Column");          ShuffleColText = new JTextField(1);
        JButton SwapButton = new JButton("Swap");                          SwapTextX1 = new JTextField(" x1"); SwapTextY1 = new JTextField(" y1");
                                                                           SwapTextX2 = new JTextField(" x2"); SwapTextY2 = new JTextField(" y2");
        JButton ShuffleButton = new JButton("Shuffle Dashboard");     
        
        pane.add(deleteRowButton);       pane.add(deleteRowText);
        pane.add(ShuffleRowButton);      pane.add(ShuffleRowText);
        pane.add(deleteColButton);       pane.add(deleteColText);
        pane.add(ShuffleColButton);      pane.add(ShuffleColText);
        pane.add(SwapButton);            pane.add(SwapTextX1);              pane.add(SwapTextY1);
                                         pane.add(SwapTextX2);              pane.add(SwapTextY2);
        pane.add(ShuffleButton);   
        
        
        JLabel scoreLabel = new JLabel("Βαθμολογία: " + dashboard.getScore() + " / 30");
        JLabel livesLabel = new JLabel("Ζωές: " + dashboard.getLives());
        JLabel helpLabel = new JLabel("Βοήθειες: " + dashboard.getTries() +" / 7              ");
        pane.add(scoreLabel);;  
        pane.add(livesLabel);
        pane.add(helpLabel);
        
        deleteRowButton.addActionListener(deleteRowButtonListener);
        ShuffleRowButton.addActionListener(ShuffleRowButtonListener);
        deleteColButton.addActionListener(deleteColButtonListener);
        ShuffleColButton.addActionListener(ShuffleColButtonListener);
        SwapButton.addActionListener(SwapListener);
        ShuffleButton.addActionListener(ShuffleListener);
        checkButton.addActionListener(checkButtonListener);
        
        
        pane.add(checkButton);
        PrintLetters();
        
        SwapTextX1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                SwapTextX1.setText("");
            }
        });
        SwapTextY1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                SwapTextY1.setText("");
            }
        });
        SwapTextX2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                SwapTextX2.setText("");
            }
        });
        SwapTextY2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                SwapTextY2.setText("");
            }
        });
    }
    
    ActionListener CheckListener = (ActionEvent e) -> {
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                System.out.println(array[i][j].toString());
            }
        }
    };
    
    public MouseListener createMouseListener(){
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3)
                {
                    System.out.println("Detected Mouse Right Click!");
                    String rename = JOptionPane.showInputDialog("Give you new nickname:");
                    try{
                        if(rename.length()<1){
                            dashboard.setNickname("Unknown");
                        }
                        else{
                            dashboard.setNickname(rename);
                        }
                    }catch(NullPointerException ex){}
                }
            }

            @Override
            public void mousePressed(MouseEvent e) { 
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        return ml;
    }
    
    protected static PopupMenu createPopupMenu() {
        final PopupMenu popup = new PopupMenu();
        MenuItem aboutItem = new MenuItem("About");
        Menu displayMenu = new Menu("Display");
        MenuItem errorItem = new MenuItem("Error");
        MenuItem warningItem = new MenuItem("Warning");
        MenuItem infoItem = new MenuItem("Info");
        MenuItem noneItem = new MenuItem("None");
        MenuItem exitItem = new MenuItem("Exit");
        // Add components to pop-up menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.addSeparator();
        popup.add(displayMenu);
        displayMenu.add(errorItem);
        displayMenu.add(warningItem);
        displayMenu.add(infoItem);
        displayMenu.add(noneItem);
        popup.add(exitItem);
        return popup;
    }

//Inner class to handle events
  private class WindowHandler extends WindowAdapter implements ActionListener
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }

    public void actionPerformed(ActionEvent e)
    {
//      System.out.println(e.getActionCommand());
      //check to see if the action command is equal to exit
      if(e.getActionCommand().equalsIgnoreCase("Exit"))
      {
        System.exit(0);
      }
      else if(e.getActionCommand().equalsIgnoreCase("About"))
      {
        JOptionPane.showMessageDialog(null, "Αναστάσιος Βάνης icsd12017\nΝικόλαος Χαϊκάλης icsd12200\n\tJava 2016-2017.", "About", JOptionPane.PLAIN_MESSAGE);
      }
      else if(e.getActionCommand().equalsIgnoreCase("New Game")){
        dispose();
        new gui();
      }
      else if(e.getActionCommand().equalsIgnoreCase("Help")){
          JOptionPane.showMessageDialog(null, "Παίξε μέχρι να νικήσεις... Αν μπορείς :) ", "Help", JOptionPane.PLAIN_MESSAGE);
      }
    }//actionPerformed()
  }//windowHandler - Inner Class ends here
    
    /**
     * Kanw swap 2 grammata anametaksi tous.
     */
    ActionListener SwapListener = (ActionEvent e) -> {
        double curX = Double.parseDouble(SwapTextX1.getText());
        double curY = Double.parseDouble(SwapTextY1.getText());
        double willX = Double.parseDouble(SwapTextX2.getText());
        double willY = Double.parseDouble(SwapTextY2.getText());
        try{
            ar.Move(curX, curY, willX, willY);

            JButton temp = letterButton[(int)willX][(int)willY];
            letterButton[(int)willX][(int)willY] = letterButton[(int)curX][(int)curY];
            letterButton[(int)curX][(int)curY] = temp;
            ReFixGrid();
        }catch(ArrayIndexOutOfBoundsException ex){}
    };
    
    /**
     * Anakateuw olo ton pinaka.
     */
    ActionListener ShuffleListener = (ActionEvent e) -> {
        ar.AnadiataksiGrammatwn(array.length);
        ar.getDashboard().setTries(ar.getDashboard().getTries()+1);
        ReFixGrid();
    };
    
    /**
     * Diagrafi grammis:
     */
    ActionListener deleteRowButtonListener = (ActionEvent e) -> {
        try{
            int row = Integer.valueOf(deleteRowText.getText());
            ar.DeleteRow(array.length, row);
            ar.getDashboard().setTries(ar.getDashboard().getTries()+1);
            ReFixGrid();
        }
        catch(ArrayIndexOutOfBoundsException ex){}
        catch(NumberFormatException ex){} 
    };
    
    /**
     * Diagrafi stilis
     */
    ActionListener deleteColButtonListener = (ActionEvent e) -> {
        try{
            int row = Integer.valueOf(deleteColText.getText());
            ar.DeleteColumn(array.length, row);
            ar.getDashboard().setTries(ar.getDashboard().getTries()+1);
            ReFixGrid();
        }
        catch(ArrayIndexOutOfBoundsException ex){}
        catch(NumberFormatException ex){} 
    };
    
    /**
     * Anakatema Grammis
     */
    ActionListener ShuffleRowButtonListener = (ActionEvent e) -> {
        try{
            int row = Integer.valueOf(ShuffleRowText.getText());
            ar.ShuffleRow(array.length, row);
            ar.getDashboard().setTries(ar.getDashboard().getTries()+1);
            ReFixGrid();
        }
        catch(ArrayIndexOutOfBoundsException ex){}
        catch(NumberFormatException ex){} 
    };
    
    /**
     * Anakatema Stilis
     */
    ActionListener ShuffleColButtonListener = (ActionEvent e) -> {
        try{
            int row = Integer.valueOf(ShuffleColText.getText());
            ar.ShuffleColumn(array.length, row);
            ar.getDashboard().setTries(ar.getDashboard().getTries()+1);
            ReFixGrid();
        }
        catch(ArrayIndexOutOfBoundsException ex){}
        catch(NumberFormatException ex){} 
    };
    
    ActionListener checkButtonListener = (ActionEvent e) -> {
        ArrayList<CheckWord> list = new ArrayList();
        for(int i=0; i<letterButton.length; i++){
            for(int j=0; j<letterButton.length; j++){
               if(letterButton[i][j].getBackground().equals(Color.yellow)){
                    CheckWord cw = new CheckWord(i, j, dashboard);
                    list.add(cw);
               }
            }
        }
        String flag = ar.FindTheWord(list);
        JOptionPane.showMessageDialog( null, flag);
        ReFixGrid();
    };
    
    public void ReFixGrid(){
        if(GameOver())
            return;
        getContentPane().removeAll();
        FixDashboard();
        pane.remove(gridPanel);
        PrintLetters();
        repaint();
        revalidate();
        ar.DisplayArray();
    }
    public void PrintLetters(){
        array = ar.getArray();
        letterButton = new JButton[array.length][array.length];
        grid = new GridLayout(array.length, array.length);
        gridPanel = new JPanel();

        gridPanel.setLayout(grid);
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                letterButton[i][j] = new JButton();
                String temp = String.valueOf(array[i][j].getLetter());
                temp += Integer.toString(array[i][j].getRank());
                letterButton[i][j].setText(temp);
                letterButton[i][j].setBackground(array[i][j].getColor());
                
                Color tempColor = array[i][j].getColor();
                Letter tmpLetter = array[i][j];
                ActionListener listener = (ActionEvent e) -> {
                    if(((JButton) e.getSource()).getBackground().equals(Color.yellow)){
                        System.out.println("colors are equals" + tempColor);
                        ((JButton) e.getSource()).setBackground(tempColor);
                        return;
                    }
                    
                    if(((JButton) e.getSource()).getBackground().equals(Color.pink) && tmpLetter.getLetter() == '?'){
                        try {
                            String joker = JOptionPane.showInputDialog("Insert a value for Joker");
                            if(joker != null && joker.length()>1){
                                JOptionPane.showMessageDialog( null, "Wrong Insert" );
                                return;
                            }
                            ((JButton) e.getSource()).setText(joker+tmpLetter.getRank());
                            

                            tmpLetter.setLetter(joker.charAt(0));
                            return;
                        }catch(NullPointerException ex){
                            ((JButton) e.getSource()).setText(String.valueOf(tmpLetter.getLetter())+tmpLetter.getRank());
                            return;
                        }
                        
                    }
                    ((JButton) e.getSource()).setBackground(Color.yellow);
                };

                letterButton[i][j].addActionListener(listener);


                gridPanel.add(letterButton[i][j]);
            }
        }
        pane.add(gridPanel);
    }
    
    
    public boolean GameOver(){
        if(ar.getDashboard().getLives() <= 0 || ar.getDashboard().getTries() > 7){
            getContentPane().removeAll();
            repaint();
            revalidate();
            JOptionPane.showMessageDialog( null, "Game Over" );
            return true;
        }
        else if(ar.getDashboard().getScore()>=30){
            getContentPane().removeAll();
            repaint();
            revalidate();
            JOptionPane.showMessageDialog( null, "Congratulations " + dashboard.getNickname() +" !!!");
            return true;
        }
        return false;
    }
    
    //Setting Nimbus GUI.
    void CuteGUI(){
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
