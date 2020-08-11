package tdc.edu.vn.test.Model;

public class SanPham {
    String tensp;
    String masp;
    String loai;
    String conlai;
    String banduoc;

    public String getConlai() {
        return conlai;
    }

    public void setConlai(String conlai) {
        this.conlai = conlai;
    }

    public String getBanduoc() {
        return banduoc;
    }

    public void setBanduoc(String banduoc) {
        this.banduoc = banduoc;
    }
    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    @Override
    public String toString() {
        return "SanPham{" +
                "tensp='" + tensp + '\'' +
                ", masp='" + masp + '\'' +
                ", loai='" + loai + '\'' +
                ", conlai='" + conlai + '\'' +
                ", banduoc='" + banduoc + '\'' +
                '}';
    }
}
