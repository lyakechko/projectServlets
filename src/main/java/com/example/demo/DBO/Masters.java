package com.example.demo.DBO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "masters")
public class Masters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "seniority")
    private Double seniority;
    @Column(name = "qualifications")
    private String qualifications;
    @Column(name = "paymentPerHour")
    private Double paymentPerHour;
    @OneToMany(mappedBy = "masters")
    private List<Evaluation> evaluations;


    public Masters(Integer id, String fullName, Double seniority, String qualifications, Double paymentPerHour) {
        this.id = id;
        this.fullName = fullName;
        this.seniority = seniority;
        this.qualifications = qualifications;
        this.paymentPerHour = paymentPerHour;
    }

    public Masters() {
    }

    public static MastersBuilder builder() {
        return new MastersBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Double getSeniority() {
        return this.seniority;
    }

    public String getQualifications() {
        return this.qualifications;
    }

    public Double getPaymentPerHour() {
        return this.paymentPerHour;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSeniority(Double seniority) {
        this.seniority = seniority;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setPaymentPerHour(Double paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Masters)) return false;
        final Masters other = (Masters) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$fullName = this.getFullName();
        final Object other$fullName = other.getFullName();
        if (this$fullName == null ? other$fullName != null : !this$fullName.equals(other$fullName)) return false;
        final Object this$seniority = this.getSeniority();
        final Object other$seniority = other.getSeniority();
        if (this$seniority == null ? other$seniority != null : !this$seniority.equals(other$seniority)) return false;
        final Object this$qualifications = this.getQualifications();
        final Object other$qualifications = other.getQualifications();
        if (this$qualifications == null ? other$qualifications != null : !this$qualifications.equals(other$qualifications))
            return false;
        final Object this$paymentPerHour = this.getPaymentPerHour();
        final Object other$paymentPerHour = other.getPaymentPerHour();
        if (this$paymentPerHour == null ? other$paymentPerHour != null : !this$paymentPerHour.equals(other$paymentPerHour))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Masters;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $fullName = this.getFullName();
        result = result * PRIME + ($fullName == null ? 43 : $fullName.hashCode());
        final Object $seniority = this.getSeniority();
        result = result * PRIME + ($seniority == null ? 43 : $seniority.hashCode());
        final Object $qualifications = this.getQualifications();
        result = result * PRIME + ($qualifications == null ? 43 : $qualifications.hashCode());
        final Object $paymentPerHour = this.getPaymentPerHour();
        result = result * PRIME + ($paymentPerHour == null ? 43 : $paymentPerHour.hashCode());
        return result;
    }

    public String toString() {
        return "Masters(id=" + this.getId() + ", fullName=" + this.getFullName() + ", seniority=" + this.getSeniority() + ", qualifications=" + this.getQualifications() + ", paymentPerHour=" + this.getPaymentPerHour() + ")";
    }

    public static class MastersBuilder {
        private Integer id;
        private String fullName;
        private Double seniority;
        private String qualifications;
        private Double paymentPerHour;

        MastersBuilder() {
        }

        public MastersBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public MastersBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public MastersBuilder seniority(Double seniority) {
            this.seniority = seniority;
            return this;
        }

        public MastersBuilder qualifications(String qualifications) {
            this.qualifications = qualifications;
            return this;
        }

        public MastersBuilder paymentPerHour(Double paymentPerHour) {
            this.paymentPerHour = paymentPerHour;
            return this;
        }

        public Masters build() {
            return new Masters(id, fullName, seniority, qualifications, paymentPerHour);
        }

        public String toString() {
            return "Masters.MastersBuilder(id=" + this.id + ", fullName=" + this.fullName + ", seniority=" + this.seniority + ", qualifications=" + this.qualifications + ", paymentPerHour=" + this.paymentPerHour + ")";
        }
    }
}
