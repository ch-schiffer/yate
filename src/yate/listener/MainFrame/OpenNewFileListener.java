package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import yate.model.Model;
import yate.view.View;

/**
 *
 * @author Laurin
 */
public class OpenNewFileListener extends MainFrameListener implements ActionListener {

    public OpenNewFileListener(View view, Model model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser openFile = new JFileChooser();
        openFile.showOpenDialog(null);

        File file = openFile.getSelectedFile();

        //Logic here
    }

}
