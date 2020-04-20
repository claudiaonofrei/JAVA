package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chart", schema = "musicalbums", catalog = "")
public class Lab9ChartEntity {
    private int chartId;
    private String name;

    @Id
    @Column(name = "chart_id", nullable = false)
    public int getChartId() {
        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lab9ChartEntity that = (Lab9ChartEntity) o;
        return chartId == that.chartId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chartId, name);
    }
}
