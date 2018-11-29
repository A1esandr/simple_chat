package chat.app;

import chat.view.SwingView;

public class App {

    private SwingView swingView;

    public App(){
        this.swingView = new SwingView();
    }

    public void start(){
        this.swingView.display();
    }
}
