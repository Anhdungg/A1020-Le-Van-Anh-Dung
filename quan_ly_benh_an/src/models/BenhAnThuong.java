package models;

public class BenhAnThuong extends BenhAn {
    String phiNamVien;

    public BenhAnThuong(String stt, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien,
                        String ngayRaVien, String lyDoNhapVien, String phiNamVien) {
        super(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public String getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(String phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String writeFile() {
        return super.writeFile() + "," + this.phiNamVien;
    }

    @Override
    public String showInformation() {
        return super.showInformation() + ", Phí nằm viện: " + this.phiNamVien;
    }

    @Override
    public String toString() {
        return "BenhAnThuong{" +
                "phiNamVien='" + phiNamVien + '\'' +
                '}';
    }
}
