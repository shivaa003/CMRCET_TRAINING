public class LibraryMember {
    private String name;
    private String memberId;
    private String email;

    public LibraryMember(String name, String memberId, String email) {
        this.name = name;
        this.memberId = memberId;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Member ID: " + memberId + ", Email: " + email;
    }
}
