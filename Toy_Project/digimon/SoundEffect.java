package digimon;																	//22_04_04_22_43

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class SoundEffect {
	public void sound() {
        File bgm;
        AudioInputStream stream;													// 오디오의 형식 및 길이가 가리키는 입력 스트림
        AudioFormat format;															// 사운드 스트림내에서 데이터의 특정의 배열을 지정하는 클래스
        DataLine.Info info;															// 데이터 라인으로 지원 되는 오디오 형식
        
        bgm = new File("11.Car Horn 2X by zerolagtime Id-66586.wav");				// 효과음 경로
        
        Clip clip;																	 
        
        try {
               stream = AudioSystem.getAudioInputStream(bgm);						// 지정된 오디오 입력 스트림을 변환해, 나타난 인코딩의 오디오 입력 스트림을 취득					
               format = stream.getFormat();											// 입력 스트림에 있는 사운드 데이터의 오디오 형식
               info = new DataLine.Info(Clip.class, format);						// 단일의 오디오 형식을 포함한 지정한 정보로부터 데이터 라인의 정보 객체를 구축
               clip = (Clip)AudioSystem.getLine(info);
               clip.open(stream);													// 지정한 오디오 입력 스트림내에 제시되고 있는 형식 및 오디오 데이터로 클립을 연다.
               clip.loop(1);														// 반복 횟수
               clip.start();														// 재생 시작
               
        } catch (Exception e) {
               System.out.println("[ERROR] 관리자에게 버그 보내기 ");						// 에러 메시지
               e.printStackTrace();
        }
	}
}
