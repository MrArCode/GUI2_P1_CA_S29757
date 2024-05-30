public enum State {
    NEW("New"),
    SAVED("Saved"),
    MODIFIED("Modified");

    private final String displayName;

    State(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
