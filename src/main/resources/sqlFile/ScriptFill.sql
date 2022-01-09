INSERT INTO Info_Olympic_Village(Description)
VALUES ('The 2020 Summer Olympics (Japanese: 2020年夏季オリンピック, Hepburn: Nisen Nijū-nen Kaki Orinpikku), officially the Games of the XXXII Olympiad (第三十二回オリンピック競技大会, Dai Sanjūni-kai Orinpikku Kyōgi Taikai) and branded as Tokyo 2020 (東京2020, Tōkyō Nii Zero Nii Zero), was an international multi-sport event held from 23 July to 8 August 2021 in Tokyo, Japan, with some preliminary events that began on 21 July.' ||
        'The United States topped the medal count by both total golds (39) and total medals (113), with China finishing second by both respects (38 and 88). Host nation Japan finished third, setting a record for the most gold medals and total medals ever won by their delegation at an Olympic Games with 27 and 58.' ||
        'The unit of ''Size of OV_Area'' : Hectares.' ||
        '''Size of Building'' describe how many people can live in it.' ||
        'The unit of Height is cm.' ||
        'The unit of Weight is kg.');

INSERT INTO OV_Area(Name, "size(ha)", Description, ID_Village)
VALUES ('Training area', 3.1,
        'This area contains all the training venues and training equipment needed by the players.', 1),
       ('Dormitory area', 5.2, 'This area contains accommodation for all athletes, coaches, volunteers and staff.', 1),
       ('Olympic Plaza', 1.2, 'This area is used to host various events.', 1),
       ('Functional area', 0.5,
        'This area is used for athletes or tourists seeking help. People from various countries can also hold press conferences here.',
        1);

INSERT INTO Location(Name, Description, ID_Area)
VALUES ('Main_Dormitories', 'There are lots of buildings and about 70% athletes live in there.', 2),
       ('Volunteers resting place',
        'There are some sheds here. Volunteers can take a break here and receive some tools.', 4),
       ('Food street',
        'It''s on the right side of the dormitory area. People can buy lots of food from different countries.', 2),
       ('Stage', 'People can hold cultural performances here.', 3),
       ('Running track A', 'Athletes can train various track and field events here.', 1);

INSERT INTO Building(Name, "size(ppl)", working_time, end_time, id_loc)
VALUES ('European space', '2000', '00:00:00', '00:00:00', 1),
       ('Chinese food center', 400, '08:00:00', '20:00:00', 3),
       ('Delicious England', 50, '10:00:00', '20:00:00', 3),
       ('Asia and Australia space', 4000, '00:00:00', '00:00:00', 1),
       ('Unmanned shop', 0, '00:00:00', '00:00:00', 5),
       ('Americas Space', 3000, '00:00:00', '00:00:00', 1),
       ('Prayer center', 1000, '06:00:00', '22:00:00', 1);

INSERT INTO Dormitory(name, dor_area, id_building)
VALUES ('Chinese Panda', 'For Chinese athletes and workers.', 4),
       ('Australian Kangaroo', 'For Australians athletes and worker', 4),
       ('Russian bear', 'For Russian athletes and workers.', 1),
       ('American Eagle', 'For American athletes and workers.', 5),
       ('Canadian goose', 'For Canadian athletes and workers.', 5);

INSERT INTO Church(name, believe, prayer_time, end_time, id_building)
VALUES ('Santa Maria prayer room', 'Catholic', '09:00:00', '10:00:00', 7),
       ('Islamic prayer room', 'Islam', '12:30:00', '13:00:00', 7),
       ('Buddhist temple', 'Buddhism', null, null, 7),
       ('Hinduism prayer room', 'Hinduism', null, null, 7),
       ('Spaghetti room', 'Flying Spaghetti Monster', null, null, 7);

INSERT INTO Canteen(name, food_kind, is_halal, evaluation, id_building)
VALUES ('Sichuan taste', 'Sichuan food. Very spicy.', false, 5, 2),
       ('Catch Moon', 'Dessert(Moon cake).', false, 4, 2),
       ('Roma road', 'Classic Italian food.', false, 5, 1),
       ('Teremok', 'blini, pelmeni, kvass, borscht', false, 4, 1),
       ('DELICIOUS ENGLISH food', 'Stargazy pie, Fish and chips', false, 0, 1);

-- If we want to create an person, we need to create the LP at the first.
INSERT INTO Location_Person(ID_Loc, ID_Building, Details)
VALUES (1, 1, 'He is sleeping in the Dormitory.'),
       (3, 2, 'He bought some tofu and chicken.'),
       (1, 4, 'She is cooking some fish.'),
       (4, null, 'He is setting up the stage.'),
       (2, null, 'She is relaxing and eating some food.'),
       (5, null, 'He is running and training.'),
       (5, 5, 'He is thirty and want to buy some energy drink.'),
       (5, null, 'He is He is training athletes');

INSERT INTO Person(Name, ID_LP)
VALUES ('LeBron James', 1),
       ('Huang Siyuan', 2),
       ('Sarah Voss', 3),
       ('Evan Zhang', 4),
       ('Hashimoto Seiko', 5),
       ('Su Bingtian', 6),
       ('Justin Gatlin', 7),
       ('Randy Huntington', 8);

-- About the countries, we need to use the shorthand for them
-- Check this site
-- https://sustainablesources.com/resources/country-abbreviations/

INSERT INTO Athlete("height(cm)", "weight(kg)", Nationality, Sport, Record, ID_Person)
VALUES (206, 113, 'US', 'Basketball', '2× Olympic Gold Medal winner: 2008, 2012', 1),
       (168, 56, 'DE', 'Artistic gymnastics', 'the Stuttgart and Birmingham World Cups No.5 and No.8', 3),
       (163, 53, 'JP', 'Speed skater', '1988 Winter Olympics fifth in both the 500 and 1000 m speed skating events', 5),
       (171, 64, 'CH', '100 metres', 'Su clocked a time of 9.83 seconds in the 2020 Summer Olympics men''s 100 m semi-finals, thereby setting a new Asian record and becoming the second Asian sprinter to have ever qualified for a men''s 100 metres Olympic final.', 6),
       (185, 79, 'US', '100 metres', 'the 2004 Summer Olympics in Athens - Gold medal - 100 metres.', 7);

INSERT INTO Workplace_staff(ID_Loc, ID_Building, Details)
VALUES (1, 4, 'Siyuan manages various affairs of the dormitory.'),
       (4, null, 'He is responsible for setting up the stage.'),
       (5, null, 'He is responsible for training athletes.');

INSERT INTO Staff_Volunteers(id_ws, id_person)
VALUES (1, 2),
       (2, 4),
       (3, 8);