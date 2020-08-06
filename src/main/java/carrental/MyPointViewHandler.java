package carrental;

import carrental.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPointViewHandler {


    @Autowired
    private MyPointRepository myPointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCarReserved_then_CREATE_1 (@Payload CarReserved carReserved) {

        System.out.println("!!!!!!!!!!! whenCarReserved_then_CREATE_1 확인 !!!!!!!!!!! : " + carReserved.getProcStatus());

        try {
            if (carReserved.isMe()) {
                // view 객체 생성
                List<MyPoint> myPointList = myPointRepository.findByResrvNo(carReserved.getResrvNo());
                MyPoint myPoint = new MyPoint();
                myPoint.setResrvNo(carReserved.getResrvNo());
                if (myPointList.size() > 0) {
                    myPoint = myPointList.get(0);
                }
                // view 객체에 이벤트의 Value 를 set 함
                myPoint.setPoint(Long.valueOf(500));
                myPoint.setResrvNo(carReserved.getResrvNo());
                myPoint.setCarNo(carReserved.getCarNo());
                myPoint.setId(carReserved.getId());
                // view 레파지 토리에 save
                if ("RESERVED".equals(carReserved.getProcStatus())) {
                    myPointRepository.save(myPoint);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCarRentalCanceled_then_CREATE_2 (@Payload CarRentalCanceled carRentalCanceled) {

        System.out.println("!!!!!!!!!!! whenCarRentalCanceled_then_CREATE_2 확인 !!!!!!!!!!! : " + carRentalCanceled.getProcStatus());

        try {
            if (carRentalCanceled.isMe()) {
                // view 객체 생성
                List<MyPoint> myPointList = myPointRepository.findByResrvNo(carRentalCanceled.getResrvNo());
                MyPoint myPoint = new MyPoint();
                myPoint.setResrvNo(carRentalCanceled.getResrvNo());
                if (myPointList.size() > 0) {
                    myPoint = myPointList.get(0);
                }
                // view 객체에 이벤트의 Value 를 set 함
                myPoint.setId(carRentalCanceled.getId());
                myPoint.setResrvNo(carRentalCanceled.getResrvNo());
                myPoint.setCarNo(carRentalCanceled.getCarNo());
                myPoint.setPoint(Long.valueOf(-1000));
                // view 레파지 토리에 save
                if ("CAR_RENTAL_CANCELED".equals(carRentalCanceled.getProcStatus()) || "PAYMENT_CANCELED".equals(carRentalCanceled.getProcStatus())) {
                    myPointRepository.save(myPoint);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCarRented_then_CREATE_3 (@Payload CarRented carRented) {

        System.out.println("!!!!!!!!!!! whenCarRented_then_CREATE_3 확인 !!!!!!!!!!! : " + carRented.getProcStatus());

        try {
            if (carRented.isMe()) {
                // view 객체 생성
                List<MyPoint> myPointList = myPointRepository.findByResrvNo(carRented.getResrvNo());
                MyPoint myPoint = new MyPoint();
                myPoint.setResrvNo(carRented.getResrvNo());
                if (myPointList.size() > 0) {
                    myPoint = myPointList.get(0);
                }
                // view 객체에 이벤트의 Value 를 set 함
                myPoint.setId(carRented.getId());
                myPoint.setResrvNo(carRented.getResrvNo());
                myPoint.setCarNo(carRented.getCarNo());
                myPoint.setPoint(Long.valueOf(1000));
                // view 레파지 토리에 save
                if ("CAR_RENTED".equals(carRented.getProcStatus()) || "PAID".equals(carRented.getProcStatus())) {
                    myPointRepository.save(myPoint);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCarReservationCanceled_then_CREATE_4 (@Payload CarReservationCanceled carReservationCanceled) {

        System.out.println("!!!!!!!!!!! whenCarReservationCanceled_then_CREATE_4 확인 !!!!!!!!!!! : " + carReservationCanceled.getProcStatus());

        try {
            if (carReservationCanceled.isMe()) {
                // view 객체 생성
                List<MyPoint> myPointList = myPointRepository.findByResrvNo(carReservationCanceled.getResrvNo());
                MyPoint myPoint = new MyPoint();
                myPoint.setResrvNo(carReservationCanceled.getResrvNo());
                if (myPointList.size() > 0) {
                    myPoint = myPointList.get(0);
                }
                // view 객체에 이벤트의 Value 를 set 함
                myPoint.setId(carReservationCanceled.getId());
                myPoint.setResrvNo(carReservationCanceled.getResrvNo());
                //myPoint.setCarNo(carReservationCanceled.getCarNo());
                myPoint.setPoint(Long.valueOf(-500));
                // view 레파지 토리에 save
                if ("RESERVATION_CANCELED".equals(carReservationCanceled.getProcStatus())) {
                    myPointRepository.save(myPoint);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}