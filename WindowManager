public class WindowManager {
    private String state;

    public WindowManager() {
        this.state = "closed"; // État initial de la fenêtre est fermée
    }

    public void openWindow() {
        this.state = "open";
        System.out.println("Fenêtre ouverte.");
    }

    public void closeWindow() {
        this.state = "closed";
        System.out.println("Fenêtre fermée.");
    }

    public void tiltWindow() {
        this.state = "tilted";
        System.out.println("Fenêtre inclinée.");
    }

    public String getState() {
        return this.state;
    }

    public static void main(String[] args) {
        WindowManager windowManager = new WindowManager();
        windowManager.openWindow();
        windowManager.tiltWindow();
        windowManager.closeWindow();
    }
}
