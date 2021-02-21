CREATE TABLE public.item(
  id BIGSERIAL PRIMARY KEY,
  item_name varchar(255),
  carton_price double precision,
  num_of_item_in_carton integer
);

---- ITEM ----
INSERT INTO ITEM ( ID, ITEM_NAME, CARTON_PRICE, NUM_OF_ITEM_IN_CARTON ) VALUES (1, 'Penguin-ears', 175, 20);
INSERT INTO ITEM ( ID, ITEM_NAME, CARTON_PRICE, NUM_OF_ITEM_IN_CARTON ) VALUES (2, 'Horseshoe', 825, 5);

