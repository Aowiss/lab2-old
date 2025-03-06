public interface PlatState {
    void raise(Platform platform, double amount);
    void lower(Platform platform, double amount);
}
