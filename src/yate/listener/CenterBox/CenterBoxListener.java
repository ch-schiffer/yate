package yate.listener.CenterBox;

import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 *
 * @author Laurin
 */
public abstract class CenterBoxListener {

    //Die übergebene View.
    protected final CenterBoxView view;
    //Das übergebene Model.
    protected final CenterBoxModel model;

    /**
     * Der allgemeine Konstuktor der abstrakten Klasse der sicherstellt, dass
     * eine passende View und ein passendes Model übergeben wird.
     *
     * @param view Eine CenterBoxView.
     * @param model Ein CenterBoxModel.
     */
    public CenterBoxListener(CenterBoxView view, CenterBoxModel model) {
        this.view = view;
        this.model = model;
    }

}
