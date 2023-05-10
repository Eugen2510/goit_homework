package module13;

public class User{
    private int id;
    private String name;
    private String username;
    private String email;

    private User.Address address;

    private String phone;
    private String website;
    private User.Company company;

    public User(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    private static class Address{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public Address(String street, String suite, String city, String zipcode,Geo geo) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.geo = geo;
        }

        public Address(){

        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", suite='" + suite + '\'' +
                    ", city='" + city + '\'' +
                    ", zipcode='" + zipcode + '\'' +
                    ", geo=" + geo +
                    '}';
        }

        private static class Geo{
            private double lat;
            private double lng;

            public Geo(double lat, double lng) {
                this.lat = lat;
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            @Override
            public String toString() {
                return "Geo{" +
                        "lat=" + lat +
                        ", lng=" + lng +
                        '}';
            }
        }
    }


    private static class Company{
        String name;
        String catchPhrase;
        String bs;

        public Company(String name, String catchPhrase, String bs) {
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    ", catchPhrase='" + catchPhrase + '\'' +
                    ", bs='" + bs + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\nusername='" + username + '\'' +
                "\nemail='" + email + '\'' +
                "\naddress=" + address +
                "\nphone='" + phone + '\'' +
                "\nwebsite='" + website + '\'' +
                "\ncompany=" + company +
                '}';
    }

    public static class UserBuilder{
        private int id;
        private String name;
        private String username;
        private String email;

        private User.Address address;

        private String phone;
        private String website;
        private User.Company company;

        public UserBuilder id(int id){
            this.id = id;
            return this;
        }

        public UserBuilder name(String name){
            this.name = name;
            return this;
        }

        public UserBuilder username(String username){
            this.username = username;
            return this;
        }

        public UserBuilder email(String email){
            this.email = email;
            return this;
        }

        public UserBuilder address(Address address){
            this.address = address;
            return this;
        }

        public UserBuilder phone(String phone){
            this.phone = phone;
            return this;
        }

        public UserBuilder website(String website){
            this.website = website;
            return this;
        }

        public UserBuilder company(Company company){
            this.company = company;
            return this;
        }

        public User build(){
            User user = new User();
            user.id = this.id;
            user.name = this.name;
            user.username = this.username;
            user.email = this.email;
            user.address = this.address;
            user.phone = this.phone;
            user.website = this.website;
            user.company = this.company;

            return user;
        }


    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }
}

