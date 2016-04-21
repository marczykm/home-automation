#define BLUE_PIN 3
#define RED_PIN 5
#define GREEN_PIN 6

int r = 0;
int g = 0;
int b = 0;

int currentRed = 0;
int currentGreen = 0;
int currentBlue = 0;

void setup()
{
  pinMode(RED_PIN, OUTPUT);
  pinMode(GREEN_PIN, OUTPUT);
  pinMode(BLUE_PIN, OUTPUT);

  digitalWrite(RED_PIN, LOW);
  digitalWrite(GREEN_PIN, LOW);
  digitalWrite(BLUE_PIN, LOW);
  
  Serial.begin(9600);
  Serial1.begin(9600);
}
void loop()
{
  int i = 0;
  String rgb = "";
  if (Serial1.available() > 0) {
    rgb = Serial1.readString();
    
    r = getValue(rgb, 'x', 0).toInt();
    g = getValue(rgb, 'x', 1).toInt();
    b = getValue(rgb, 'x', 2).toInt();
    
    turn(r,g,b);
    delay(1000);    
  }
}

String getValue(String data, char separator, int index)
{
  int found = 0;
  int strIndex[] = {0, -1};
  int maxIndex = data.length()-1;

  for(int i=0; i<=maxIndex && found<=index; i++){
    if(data.charAt(i)==separator || i==maxIndex){
        found++;
        strIndex[0] = strIndex[1]+1;
        strIndex[1] = (i == maxIndex) ? i+1 : i;
    }
  }

  return found>index ? data.substring(strIndex[0], strIndex[1]) : "";
}

void turn(int targetRed, int targetGreen, int targetBlue){
  int fadeRed = 1;
  int fadeGreen = 1;
  int fadeBlue = 1;
  
  while(currentRed != targetRed || currentGreen != targetGreen || currentBlue != targetBlue){
    if (currentRed > targetRed){
      fadeRed = -1;
    }
    if (currentGreen > targetGreen){
      fadeGreen = -1;
    }
    if (currentBlue > targetBlue){
      fadeBlue = -1;
    }
    analogWrite(RED_PIN, currentRed);
    analogWrite(GREEN_PIN, currentGreen);
    analogWrite(BLUE_PIN, currentBlue);

    if (currentRed != targetRed){
      currentRed = currentRed + fadeRed;
    }
    if (currentGreen != targetGreen){
      currentGreen = currentGreen + fadeGreen;
    }
    if (currentBlue != targetBlue){
      currentBlue = currentBlue + fadeBlue;
    }
    delay(5);
  }
  analogWrite(RED_PIN, currentRed);
  analogWrite(GREEN_PIN, currentGreen);
  analogWrite(BLUE_PIN, currentBlue);
}

