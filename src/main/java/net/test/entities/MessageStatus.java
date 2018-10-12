package net.test.entities;

public enum MessageStatus {
    Unknonw(0),
    Read(1),
    Unread(2);

    MessageStatus(int index) {
        this.index=index;
    }
    private int index;

    public int getIndex() {
        return index;
    }
}
