package carrental;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MyPoint_table")
public class MyPoint {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;

        // 소스에 직접 추가
        private String resrvNo;
        private String carNo;
        private Long point;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        // 소스에 직접 추가
        public String getResrvNo() {
            return resrvNo;
        }
        public void setResrvNo(String resrvNo) {
            this.resrvNo = resrvNo;
        }
        public String getCarNo() {
            return carNo;
        }
        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }
        public Long getPoint() {
        return point;
    }
        public void setPoint(Long point) {
        this.point = point;
    }
}
