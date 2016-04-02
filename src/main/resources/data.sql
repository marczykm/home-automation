insert into switch
(id,      name, value, on_script, off_script) values
( 1, 'switch1',   '1', 'command://ls', 'command://ping'),
( 2, 'switch2',   '0', 'http://192.168.0.102?value=255', 'http://192.168.0.102?value=0');

insert into rgb_led_strip
(id,   name, red, green, blue) values
( 1, 'rgb1',   0,     0,    0),
( 2, 'rgb2', 255,     0,  255);