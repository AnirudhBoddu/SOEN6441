package main.java.models;

public interface Observer {
    // Update on all registered properties
    public void update();

    // Update the observer on specific property
    public void update(Property property);

    // Attach with subject to observe
    public void setSubject(Subject sub);
}
