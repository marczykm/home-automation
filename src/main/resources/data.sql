insert into switch
(id,      name, value, on_script, off_script) values
( 1, 'dummySwitch',   '1', 'command://ls', 'command://ping'),
( 2, 'esp8266',   '0', 'http://192.168.0.108?pin=255x255x255', 'http://192.168.0.108?pin=0x0x0');

insert into rgb_led_strip
(id,   name, red, green, blue, script) values
( 1, 'esp8266rgb',   0,     0,    0, 'http://192.168.0.200');