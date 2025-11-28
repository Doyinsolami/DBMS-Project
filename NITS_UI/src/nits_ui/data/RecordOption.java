package nits_ui.data;

/**
 * Lightweight value object for populating JComboBoxes with database
 * identifiers while still displaying friendly labels.
 */
public final class RecordOption {

    private final int id;
    private final String label;

    public RecordOption(int id, String label) {
        this.id = id;
        this.label = label == null ? "" : label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
