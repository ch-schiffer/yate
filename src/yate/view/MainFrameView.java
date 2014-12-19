package yate.view;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SingleSelectionModel;
import yate.listener.MainFrame.ColorChangedListener;
import yate.listener.MainFrame.FontChangedListener;
import yate.listener.MainFrame.FontSizeChangedListener;
import yate.listener.MainFrame.LanguageChangedListener;
import yate.listener.MainFrame.NewFileListener;
import yate.listener.MainFrame.OpenFileListener;
import yate.listener.MainFrame.SaveAllFilesListener;
import yate.listener.MainFrame.SaveFileListener;
import yate.listener.MainFrame.TabChangedListener;
import yate.listener.MainFrame.TabCloseListener;
import yate.listener.MainFrame.TestButtonListener;
import yate.listener.MainFrame.regex.FindNextListener;
import yate.listener.MainFrame.regex.FindPreviousListener;
import yate.listener.MainFrame.regex.ReplaceAllListener;
import yate.listener.MainFrame.regex.ReplaceListener;
import yate.syntax.general.Language;

/**
 *
 * @author Laurin
 */
public class MainFrameView extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrameView() {
        initComponents();
    }

    public void addCenterBoxViewToTab(CenterBoxView view, String name,TabCloseListener l) {
        jTP_tabed.add(view, name);
        jTP_tabed.setSelectedComponent(view); //17.11.14 Neuen Tab fokussieren CHS
        CloseTab t = new CloseTab(name,l);
        jTP_tabed.setTabComponentAt(jTP_tabed.getTabCount()-1, t);
    }

    public void addProjectMenuView(ProjectMenuView view) {
        jP_Pmv.add(view);
    }
    
    public void removeTab(java.awt.Component c)
    {
        jTP_tabed.remove(c);
    }
    
    public void setCurrentTabTitle(String title) {
       ((CloseTab) jTP_tabed.getTabComponentAt(getSelectedTabIndex())).setTitle(title);
    }
    
    public int getSelectedTabIndex()
    {
        return jTP_tabed.getSelectedIndex();
    }
    
    // Schnittstelle CAR 7.12.14
    public String getSearchText () {
        return jTF_search.getText();
    }

    public String getReplaceText () {
        return jTF_replace.getText();
    }
    
    public boolean isRegex() {
        return jbCB_regex.isEnabled();
    }
    
    public void addLanguage(Language lang,LanguageChangedListener listener)
    {
        String name = lang.getLanguageName();
        
        javax.swing.JMenuItem JMI = new javax.swing.JMenuItem(name);
        addLanguageChangedListener(listener, JMI);
        jMI_languageSub.add(JMI);
    }
    
    public SingleSelectionModel getJTabedPaneModel() {
        return jTP_tabed.getModel();
    }

    public DefaultComboBoxModel<String> getFontModel() {
        return (DefaultComboBoxModel<String>) jCB_font.getModel();
    }

    public DefaultComboBoxModel<String> getFontSizeModel() {
        return (DefaultComboBoxModel<String>) jCB_fontSize.getModel();
    }

    //Listener
    public void addFontChangedListener(FontChangedListener l) {
        jCB_font.addActionListener(l);
    }

    public void addFontSizeChangedListener(FontSizeChangedListener l) {
        jCB_fontSize.addActionListener(l);
    }

    public void addNewFileListener(NewFileListener l) {
        jB_newFile.addActionListener(l);
        jMI_new.addActionListener(l);
    }

    public void addOpenFileListener(OpenFileListener l) {
        jB_open.addActionListener(l);
        jMI_open.addActionListener(l);

    }

    public void addSaveAllFileListener(SaveAllFilesListener l) {
        jB_saveAll.addActionListener(l);
        jMI_saveAll.addActionListener(l);
    }

    public void addSaveFileListener(SaveFileListener l) {
        jB_save.addActionListener(l);
        jMI_save.addActionListener(l);
    }

    public void addTestButtonListener(TestButtonListener l) {
        jB_testButton.addActionListener(l);
    }
    
    private void addLanguageChangedListener(LanguageChangedListener l,javax.swing.JMenuItem item)
    {
        item.addActionListener(l);
    }
    
    public void addTabChangedListener(TabChangedListener l) {
        jTP_tabed.addChangeListener(l);
    }
    
     public void addColorChangedListener(ColorChangedListener l) {
        jMI_editColors.addActionListener(l);
    }
    
    //RegexListener
    public void addFindNextListener(FindNextListener l) {
        jB_next.addActionListener(l);
    }

    public void addFindPreviousListener(FindPreviousListener l) {
        jB_previous.addActionListener(l);
    }

    public void addReplaceAllListener(ReplaceAllListener l) {
        jB_replaceAll.addActionListener(l);
    }

    public void addReplaceListener(ReplaceListener l) {
        jB_replace.addActionListener(l);
    }
    
        //13.12.14 CAR
    public void addRegexChangedListener(ActionListener l) {
        jbCB_regex.addActionListener(l);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jP_Menu = new javax.swing.JPanel();
        jB_newFile = new javax.swing.JButton();
        jB_open = new javax.swing.JButton();
        jB_save = new javax.swing.JButton();
        jB_saveAll = new javax.swing.JButton();
        jCB_font = new javax.swing.JComboBox();
        jCB_fontSize = new javax.swing.JComboBox();
        jB_testButton = new javax.swing.JButton();
        jP_Side = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jP_Pmv = new javax.swing.JPanel();
        jP_Center = new javax.swing.JPanel();
        jTP_tabed = new javax.swing.JTabbedPane();
        jP_searchContainer = new javax.swing.JPanel();
        jP_search = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTF_search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTF_replace = new javax.swing.JTextField();
        jB_next = new javax.swing.JButton();
        jB_previous = new javax.swing.JButton();
        jB_replace = new javax.swing.JButton();
        jB_replaceAll = new javax.swing.JButton();
        jbCB_regex = new javax.swing.JCheckBox();
        jMB_menuBar = new javax.swing.JMenuBar();
        jM_file = new javax.swing.JMenu();
        jMI_new = new javax.swing.JMenuItem();
        jMI_open = new javax.swing.JMenuItem();
        jMI_save = new javax.swing.JMenuItem();
        jMI_saveAll = new javax.swing.JMenuItem();
        jM_edit = new javax.swing.JMenu();
        jMI_editColors = new javax.swing.JMenuItem();
        jMI_languageSub = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("yate");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(800, 600));

        jP_Menu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jB_newFile.setText("Neue Datei");
        jP_Menu.add(jB_newFile);

        jB_open.setText("Datei öffnen");
        jP_Menu.add(jB_open);

        jB_save.setText("Datei speichern");
        jP_Menu.add(jB_save);

        jB_saveAll.setText("Alle Dateien speichern");
        jP_Menu.add(jB_saveAll);
        jP_Menu.add(jCB_font);

        jP_Menu.add(jCB_fontSize);

        jB_testButton.setText("test Button");
        jP_Menu.add(jB_testButton);

        getContentPane().add(jP_Menu, java.awt.BorderLayout.PAGE_START);

        jP_Side.setLayout(new javax.swing.BoxLayout(jP_Side, javax.swing.BoxLayout.LINE_AXIS));

        jP_Pmv.setLayout(new javax.swing.BoxLayout(jP_Pmv, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(jP_Pmv);

        jP_Side.add(jScrollPane1);

        getContentPane().add(jP_Side, java.awt.BorderLayout.LINE_START);

        jP_Center.setLayout(new java.awt.BorderLayout());

        jTP_tabed.setMinimumSize(new java.awt.Dimension(500, 500));
        jP_Center.add(jTP_tabed, java.awt.BorderLayout.CENTER);

        jP_searchContainer.setLayout(new java.awt.BorderLayout());

        jP_search.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Suchen:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jP_search.add(jLabel1, gridBagConstraints);

        jTF_search.setMaximumSize(new java.awt.Dimension(70, 20));
        jTF_search.setMinimumSize(new java.awt.Dimension(70, 20));
        jTF_search.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jP_search.add(jTF_search, gridBagConstraints);

        jLabel2.setText("Ersetzen:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jP_search.add(jLabel2, gridBagConstraints);

        jTF_replace.setMaximumSize(new java.awt.Dimension(70, 20));
        jTF_replace.setMinimumSize(new java.awt.Dimension(70, 20));
        jTF_replace.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jP_search.add(jTF_replace, gridBagConstraints);

        jB_next.setText("Nächstes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jP_search.add(jB_next, gridBagConstraints);

        jB_previous.setText("Vorheriges");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jP_search.add(jB_previous, gridBagConstraints);

        jB_replace.setText("Ersetzen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jP_search.add(jB_replace, gridBagConstraints);

        jB_replaceAll.setText("Alle ersetzen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jP_search.add(jB_replaceAll, gridBagConstraints);

        jbCB_regex.setText("regex");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jP_search.add(jbCB_regex, gridBagConstraints);

        jP_searchContainer.add(jP_search, java.awt.BorderLayout.WEST);

        jP_Center.add(jP_searchContainer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jP_Center, java.awt.BorderLayout.CENTER);

        jM_file.setText("Datei");

        jMI_new.setText("Neue Datei");
        jM_file.add(jMI_new);

        jMI_open.setText("Datei öffnen");
        jM_file.add(jMI_open);

        jMI_save.setText("Datei speichern");
        jM_file.add(jMI_save);

        jMI_saveAll.setText("Alle Dateien speichern");
        jM_file.add(jMI_saveAll);

        jMB_menuBar.add(jM_file);

        jM_edit.setText("Bearbeiten");

        jMI_editColors.setText("Farben bearbeiten");
        jM_edit.add(jMI_editColors);

        jMI_languageSub.setText("Sprachen");
        jM_edit.add(jMI_languageSub);

        jMB_menuBar.add(jM_edit);

        setJMenuBar(jMB_menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_newFile;
    private javax.swing.JButton jB_next;
    private javax.swing.JButton jB_open;
    private javax.swing.JButton jB_previous;
    private javax.swing.JButton jB_replace;
    private javax.swing.JButton jB_replaceAll;
    private javax.swing.JButton jB_save;
    private javax.swing.JButton jB_saveAll;
    private javax.swing.JButton jB_testButton;
    private javax.swing.JComboBox jCB_font;
    private javax.swing.JComboBox jCB_fontSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMB_menuBar;
    private javax.swing.JMenuItem jMI_editColors;
    private javax.swing.JMenu jMI_languageSub;
    private javax.swing.JMenuItem jMI_new;
    private javax.swing.JMenuItem jMI_open;
    private javax.swing.JMenuItem jMI_save;
    private javax.swing.JMenuItem jMI_saveAll;
    private javax.swing.JMenu jM_edit;
    private javax.swing.JMenu jM_file;
    private javax.swing.JPanel jP_Center;
    private javax.swing.JPanel jP_Menu;
    private javax.swing.JPanel jP_Pmv;
    private javax.swing.JPanel jP_Side;
    private javax.swing.JPanel jP_search;
    private javax.swing.JPanel jP_searchContainer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_replace;
    private javax.swing.JTextField jTF_search;
    private javax.swing.JTabbedPane jTP_tabed;
    private javax.swing.JCheckBox jbCB_regex;
    // End of variables declaration//GEN-END:variables

}