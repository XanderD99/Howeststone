-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Gegenereerd op: 27 mei 2018 om 14:14
-- Serverversie: 5.7.19
-- PHP-versie: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `howeststone`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `abilities`
--

DROP TABLE IF EXISTS `abilities`;
CREATE TABLE IF NOT EXISTS `abilities` (
  `abilityName` varchar(20) NOT NULL,
  PRIMARY KEY (`abilityName`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `abilities`
--

INSERT INTO `abilities` (`abilityName`) VALUES
('AdjacentBuff'),
('AffectedBySpellPower'),
('Aura'),
('Battlecry'),
('Charge'),
('Deathrattle'),
('Divine shield'),
('Enrage'),
('ImmuneToSpellpower'),
('Poisonous'),
('Silence'),
('Spell Damage'),
('Stealth'),
('Taunt'),
('Windfury');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cardabilities`
--

DROP TABLE IF EXISTS `cardabilities`;
CREATE TABLE IF NOT EXISTS `cardabilities` (
  `cardId` varchar(10) NOT NULL,
  `abilityName` varchar(20) DEFAULT NULL,
  KEY `fk_cardid_cardabilities` (`cardId`),
  KEY `fk_abilityname_cardabilities` (`abilityName`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `cardabilities`
--

INSERT INTO `cardabilities` (`cardId`, `abilityName`) VALUES
('CS2_231', 'null'),
('CS2_188', 'Battlecry'),
('EX1_009', 'null'),
('EX1_008', 'Divine Shield'),
('NEW1_017', 'Battlecry'),
('EX1_029', 'Deathrattle'),
('EX1_405', 'Taunt'),
('CS2_152', 'null'),
('EX1_010', 'Stealth'),
('CS2_169', 'Windfury'),
('EX1_004', 'null'),
('EX1_393', 'null'),
('EX1_012', 'Deathrattle'),
('EX1_012', 'Spell Damage'),
('NEW1_018', 'Battlecry'),
('EX1_059', 'Battlecry'),
('EX1_603', 'Battlecry'),
('EX1_162', 'AdjacentBuff'),
('EX1_162', 'Aura'),
('NEW1_023', 'null'),
('NEW1_040t', 'Taunt'),
('EX1_096', 'Deathrattle'),
('EX1_082', 'Battlecry'),
('NEW1_037', 'null'),
('EX1_058', 'Taunt'),
('EX1_058', 'Battlecry'),
('EX1_049', 'Battlecry'),
('EX1_007', 'null'),
('EX1_006', 'null'),
('EX1_089', 'Battlecry'),
('EX1_590', 'Divine Shield'),
('EX1_590', 'Battlecry'),
('EX1_103', 'Battlecry'),
('EX1_102', 'null'),
('CS2_117', 'Battlecry'),
('EX1_170', 'Poisonous'),
('EX1_finkle', 'null'),
('tt_004', 'null'),
('EX1_604', 'null'),
('CS2_181', 'Battlecry'),
('CS2_203', 'Silence'),
('CS2_203', 'Battlecry'),
('EX1_017', 'Stealth'),
('EX1_507', 'Aura'),
('EX1_412', 'Windfury'),
('EX1_020', 'Divine Shield'),
('NEW1_027', 'Aura'),
('EX1_390', 'Taunt'),
('EX1_021', 'Windfury'),
('EX1_057', 'Battlecry'),
('EX1_584', 'Spell Damage'),
('EX1_584', 'Battlecry'),
('EX1_046', 'Battlecry'),
('EX1_093', 'Taunt'),
('EX1_093', 'Battlecry'),
('EX1_396', 'Taunt'),
('EX1_023', 'Divine Shield'),
('EX1_048', 'Silence'),
('EX1_048', 'Battlecry'),
('EX1_043', 'Battlecry'),
('EX1_097', 'Taunt'),
('EX1_097', 'Deathrattle'),
('EX1_005', 'Battlecry'),
('NEW1_024', 'Battlecry'),
('CS1_069', 'Taunt'),
('EX1_558', 'Battlecry'),
('CS2_221', 'null'),
('NEW1_041', 'Battlecry'),
('EX1_028', 'Stealth'),
('EX1_067', 'Charge'),
('EX1_067', 'Divine Shield'),
('EX1_583', 'Battlecry'),
('EX1_032', 'Taunt'),
('EX1_032', 'Divine Shield'),
('EX1_002', 'Taunt'),
('EX1_002', 'Battlecry'),
('EX1_033', 'Windfury'),
('EX1_249', 'null'),
('CS2_161', 'Stealth'),
('EX1_414', 'Charge'),
('NEW1_038', 'null'),
('EX1_561', 'Battlecry'),
('EX1_563', 'Spell Damage'),
('EX1_560', 'null'),
('EX1_586', 'null'),
('GAME_002', 'null'),
('CS2_boar', 'null'),
('CS2_189', 'Battlecry'),
('CS1_042', 'Taunt'),
('EX1_508', 'null'),
('EX1_025t', 'null'),
('CS2_168', 'null'),
('EX1_506a', 'null'),
('CS2_tk1', 'null'),
('CS2_171', 'Charge'),
('EX1_011', 'Battlecry'),
('CS2_172', 'null'),
('CS2_173', 'Charge'),
('CS2_121', 'Taunt'),
('CS2_142', 'Spell Damage'),
('EX1_015', 'Battlecry'),
('CS2_120', 'null'),
('EX1_582', 'Spell Damage'),
('CS2_141', 'Battlecry'),
('CS2_125', 'Taunt'),
('CS2_118', 'null'),
('CS2_122', 'Aura'),
('EX1_019', 'Battlecry'),
('CS2_127', 'Taunt'),
('EX1_084', 'Charge'),
('EX1_084', 'Aura'),
('CS2_124', 'Charge'),
('CS2_182', 'null'),
('CS2_147', 'Battlecry'),
('NEW1_011', 'Charge'),
('CS2_119', 'null'),
('CS2_197', 'Spell Damage'),
('CS2_179', 'Taunt'),
('CS2_131', 'Charge'),
('CS2_187', 'Taunt'),
('DS1_055', 'Battlecry'),
('CS2_226', 'Battlecry'),
('EX1_399', 'null'),
('EX1_593', 'Battlecry'),
('CS2_150', 'Battlecry'),
('CS2_155', 'Spell Damage'),
('CS2_200', 'null'),
('CS2_162', 'Taunt'),
('CS2_213', 'Charge'),
('CS2_201', 'null'),
('CS2_222', 'Aura'),
('CS2_186', 'null'),
('GVG_123', 'Spell Damage'),
('OG_120', 'Deathrattle'),
('OG_083', 'Battlecry'),
('EX1_607', 'null'),
('EX1_014t', 'null'),
('EX1_410', 'AffectedBySpellPower'),
('EX1_392', 'null'),
('CS2_104', 'null'),
('EX1_407', 'null'),
('EX1_279', 'null'),
('GAME_005', 'null'),
('EX1_277', 'ImmuneToSpellpower'),
('EX1_400', 'null'),
('CS2_025', 'null'),
('CS2_114', 'null'),
('CS2_108', 'null'),
('CS2_105', 'null'),
('CS2_023', 'null'),
('EX1_606', 'null'),
('CS2_029', 'null'),
('CS2_022', 'null'),
('CS2_032', 'null'),
('EX1_398t', 'null'),
('EX1_409t', 'null'),
('EX1_411', 'null'),
('BCON_026', 'null'),
('CS2_106', 'null'),
('CS2_112', 'null');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cards`
--

DROP TABLE IF EXISTS `cards`;
CREATE TABLE IF NOT EXISTS `cards` (
  `cardId` varchar(10) NOT NULL,
  `img` varchar(75) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `health` int(11) DEFAULT NULL,
  `type` varchar(6) DEFAULT NULL,
  `flavor` varchar(182) DEFAULT NULL,
  `playerClass` varchar(7) DEFAULT NULL,
  `cardSet` varchar(24) DEFAULT NULL,
  `attack` int(11) DEFAULT NULL,
  `name` varchar(21) DEFAULT NULL,
  `text` varchar(81) DEFAULT NULL,
  `elite` varchar(5) DEFAULT NULL,
  `ability` varchar(255) DEFAULT NULL,
  `battlecry` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`cardId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `cards`
--

INSERT INTO `cards` (`cardId`, `img`, `cost`, `health`, `type`, `flavor`, `playerClass`, `cardSet`, `attack`, `name`, `text`, `elite`, `ability`, `battlecry`) VALUES
('CS2_231', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_231.png', 0, 1, 'Minion', 'If you hit an Eredar Lord with enough Wisps, it will explode. But why?', 'Neutral', 'Classic', 1, 'Wisp', NULL, NULL, NULL, NULL),
('CS2_188', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_188.png', 1, 1, 'Minion', 'ADD ME TO YOUR DECK, MAGGOT!', 'Neutral', 'Classic', 1, 'Abusive Sergeant', 'Battlecry: Give a minion +2_Attack this turn.', NULL, NULL, '+2_Attack_this_turn'),
('EX1_009', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_009.png', 1, 1, 'Minion', 'There is no beast more frightening (or ridiculous) than a fully enraged chicken.', 'Neutral', 'Classic', 1, 'Angry Chicken', 'Has +5 Attack while damaged.', NULL, NULL, '+5_Attack_damaged'),
('EX1_008', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_008.png', 1, 1, 'Minion', '\"I solemnly swear to uphold the Light, purge the world of darkness, and to eat only burritos.\" - The Argent Dawn Oath', 'Neutral', 'Classic', 1, 'Argent Squire', 'Divine Shield', NULL, 'DivineShield', NULL),
('EX1_538t', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_538t.png', 1, 1, 'Minion', NULL, 'Hunter', 'Classic', 1, 'Hound', 'Charge', NULL, 'Charge', NULL),
('NEW1_017', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_017.png', 1, 2, 'Minion', 'Murloc. It\'s what\'s for dinner.', 'Neutral', 'Classic', 1, 'Hungry Crab', 'Battlecry: Destroy a Murloc and gain +2/+2.', NULL, NULL, 'kill_murloc_and_+2/+2'),
('EX1_029', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_029.png', 1, 1, 'Minion', 'He really just wants to be your friend, but the constant rejection is starting to really get to him.', 'Neutral', 'Classic', 1, 'Leper Gnome', 'Deathrattle: Deal 2 damage to the enemy_hero.', NULL, NULL, NULL),
('EX1_405', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_405.png', 1, 4, 'Minion', 'Have you seen the size of the shields in this game?? This is no easy job.', 'Neutral', 'Classic', 0, 'Shieldbearer', 'Taunt', NULL, 'Taunt', NULL),
('CS2_152', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/CS2_152.png', 1, 2, 'Minion', NULL, 'Neutral', 'Classic', 2, 'Squire', NULL, NULL, NULL, NULL),
('EX1_010', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_010.png', 1, 1, 'Minion', 'If you want to stop a worgen from infiltrating, just yell, \"No! Bad boy!\"', 'Neutral', 'Classic', 2, 'Worgen Infiltrator', 'Stealth', NULL, 'Stealth', NULL),
('CS2_169', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_169.png', 1, 1, 'Minion', 'They were the inspiration for the championship Taurenball team: The Dragonhawks.', 'Neutral', 'Classic', 1, 'Young Dragonhawk', 'Windfury', NULL, 'Windfury', NULL),
('EX1_004', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_004.png', 1, 1, 'Minion', 'She can\'t wait to learn Power Word: Fortitude Rank 2.', 'Neutral', 'Classic', 2, 'Young Priestess', 'At the end of your turn, give another random friendly minion +1 Health.', NULL, NULL, '+1_Health_random_friendly_minion_end_turn'),
('EX1_393', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_393.png', 2, 3, 'Minion', 'If an Amani berserker asks \"Joo lookin\' at me?!\", the correct response is \"Nah, mon\".', 'Neutral', 'Classic', 2, 'Amani Berserker', 'Has +3 Attack while damaged.', NULL, NULL, '+3_Attack_damaged'),
('NEW1_018', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_018.png', 2, 3, 'Minion', '\"I only plunder on days that end in \'y\'.\"', 'Neutral', 'Classic', 2, 'Bloodsail Raider', 'Battlecry: Gain Attack equal to the Attack\nof your weapon.', NULL, NULL, NULL),
('EX1_059', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_059.png', 2, 2, 'Minion', '\"You\'ll love my new recipe!\" he says... especially if you\'re not happy with your current number of limbs.', 'Neutral', 'Classic', 2, 'Crazed Alchemist', 'Battlecry: Swap the Attack and Health of a minion.', NULL, NULL, 'swap_Health_Attack'),
('NEW1_023', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_023.png', 2, 2, 'Minion', 'Adorable. Immune to Magic. Doesn\'t pee on the rug. The perfect pet!', 'Neutral', 'Classic', 3, 'Faerie Dragon', 'Can\'t be targeted by spells or Hero Powers.', NULL, NULL, NULL),
('NEW1_040t', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/NEW1_040t.png', 2, 2, 'Minion', NULL, 'Neutral', 'Classic', 2, 'Gnoll', 'Taunt', NULL, 'Taunt', NULL),
('EX1_096', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_096.png', 2, 1, 'Minion', 'Always roll need.', 'Neutral', 'Classic', 2, 'Loot Hoarder', 'Deathrattle: Draw a card.', NULL, NULL, NULL),
('EX1_082', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_082.png', 2, 2, 'Minion', 'He\'s not really all that crazy, he is just not as careful with explosives as he should be.', 'Neutral', 'Classic', 3, 'Mad Bomber', 'Battlecry: Deal 3 damage randomly split between all other characters.', NULL, NULL, '3_damage_split_random'),
('NEW1_037', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_037.png', 2, 3, 'Minion', 'He\'s currently trying to craft a \"flail-axe\", but all the other swordsmiths say it can\'t be done.', 'Neutral', 'Classic', 1, 'Master Swordsmith', 'At the end of your turn, give another random friendly minion +1 Attack.', NULL, NULL, '+1_Attack_end_turn_random_friendly'),
('EX1_049', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_049.png', 2, 2, 'Minion', 'His youthful enthusiasm doesn’t always equal excellence in his brews. Don’t drink the Mogu Stout!', 'Neutral', 'Classic', 3, 'Youthful Brewmaster', 'Battlecry: Return a friendly minion from the battlefield to your hand.', NULL, NULL, 'Return_friendly_minion'),
('EX1_007', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_007.png', 3, 3, 'Minion', 'He trained when he was younger to be an acolyte of joy, but things didn’t work out like he thought they would.', 'Neutral', 'Classic', 1, 'Acolyte of Pain', 'Whenever this minion takes damage, draw a_card.', NULL, NULL, NULL),
('EX1_006', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_006.png', 3, 3, 'Minion', 'WARNING. WARNING. WARNING.', 'Neutral', 'Classic', 0, 'Alarm-o-Bot', '[x]At the start of your turn,\nswap this minion with a\n random one in your hand.', NULL, NULL, NULL),
('EX1_089', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_089.png', 3, 4, 'Minion', 'Having Arcane golems at home really classes up the place, and as a bonus they are great conversation pieces.', 'Neutral', 'Classic', 4, 'Arcane Golem', 'Battlecry: Give your opponent a Mana Crystal.', NULL, NULL, '+1_available_mana_opponent'),
('EX1_103', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_103.png', 3, 3, 'Minion', 'The Coldlight murlocs reside in the darkest pits of the Abyssal Depths. So no, there\'s no getting away from murlocs.', 'Neutral', 'Classic', 2, 'Coldlight Seer', 'Battlecry: Give your other Murlocs +2 Health.', NULL, NULL, '+2_Health_friendly_murloc_all'),
('EX1_102', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_102.png', 3, 4, 'Minion', 'Laying siege isn\'t fun for anyone. It\'s not even all that effective, now that everyone has a flying mount.', 'Neutral', 'Classic', 1, 'Demolisher', 'At the start of your turn, deal 2 damage to a random enemy.', NULL, NULL, NULL),
('CS2_117', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_117.png', 3, 3, 'Minion', 'He can see really far, and he doesn\'t use a telescope like those filthy pirates.', 'Neutral', 'Classic', 3, 'Earthen Ring Farseer', 'Battlecry: Restore 3_Health.', NULL, NULL, '+3_Health'),
('EX1_170', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_170.png', 3, 3, 'Minion', 'The Sholazar Basin is home to a lot of really horrible things. If you\'re going to visit, wear bug spray. And plate armor.', 'Neutral', 'Classic', 2, 'Emperor Cobra', 'Poisonous', NULL, 'Poisonous', NULL),
('EX1_finkle', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_finkle.png', 3, 3, 'Minion', NULL, 'Neutral', 'Classic', 3, 'Finkle Einhorn', NULL, 'True', NULL, NULL),
('tt_004', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/tt_004.png', 3, 3, 'Minion', '\'Flesheating\' is an unfair name. It\'s just that there\'s not really much else for him to eat.', 'Neutral', 'Classic', 2, 'Flesheating Ghoul', 'Whenever a minion dies, gain +1 Attack.', NULL, NULL, NULL),
('CS2_181', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_181.png', 3, 7, 'Minion', 'He claims it is an old war wound, but we think he just cut himself shaving.', 'Neutral', 'Classic', 4, 'Injured Blademaster', 'Battlecry: Deal 4 damage to HIMSELF.', NULL, NULL, '-4_Health'),
('EX1_017', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_017.png', 3, 2, 'Minion', 'Stranglethorn is a beautiful place to visit, but you wouldn\'t want to live there.', 'Neutral', 'Classic', 4, 'Jungle Panther', 'Stealth', NULL, 'Stealth', NULL),
('EX1_507', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_507.png', 3, 3, 'Minion', 'Do Murlocs ever get tired of making the same old sound? Nope! Mrglglrglglglglglglgl!', 'Neutral', 'Classic', 3, 'Murloc Warleader', 'Your other Murlocs have +2 Attack.', NULL, NULL, '+2_Attack_friendly_murloc_all'),
('EX1_412', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_412.png', 3, 3, 'Minion', 'If he\'s raging now, just wait until he gets nerfed.', 'Neutral', 'Classic', 3, 'Raging Worgen', 'Has +1 Attack and Windfury while damaged.', NULL, NULL, '+1_Attack_and_Windfury_damaged'),
('EX1_020', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_020.png', 3, 1, 'Minion', 'Never wash your whites with a Scarlet Crusader.', 'Neutral', 'Classic', 3, 'Scarlet Crusader', 'Divine Shield', NULL, 'DivineShield', NULL),
('NEW1_027', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_027.png', 3, 3, 'Minion', 'When he saves enough plunder, he\'s going to commission an enormous captain\'s hat. He has hat envy.', 'Neutral', 'Classic', 3, 'Southsea Captain', 'Your other Pirates have +1/+1.', NULL, NULL, NULL),
('EX1_390', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_390.png', 3, 3, 'Minion', 'Tauren Warrior: Champion of Mulgore, Slayer of Quilboar, Rider of Thunderbluff Elevators.', 'Neutral', 'Classic', 2, 'Tauren Warrior', 'Taunt\nHas +3 Attack while damaged.', NULL, 'Taunt', NULL),
('EX1_021', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_021.png', 3, 3, 'Minion', 'He\'s stationed in the Hellfire Peninsula, but he\'s hoping for a reassignment closer to Orgrimmar, or really anywhere the ground is less on fire.', 'Neutral', 'Classic', 2, 'Thrallmar Farseer', 'Windfury', NULL, 'Windfury', NULL),
('EX1_057', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_057.png', 4, 4, 'Minion', 'Most pandaren say his brew tastes like yak. But apparently that\'s a compliment.', 'Neutral', 'Classic', 5, 'Ancient Brewmaster', 'Battlecry: Return a friendly minion from the battlefield to your hand.', NULL, NULL, 'Return_friendly_minion'),
('EX1_046', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_046.png', 4, 4, 'Minion', 'Guardians of Dark Iron Ore. Perhaps the most annoying ore, given where you have to forge it.', 'Neutral', 'Classic', 4, 'Dark Iron Dwarf', 'Battlecry: Give a minion +2_Attack this turn.', NULL, NULL, '+2_Attack_this_turn'),
('EX1_396', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_396.png', 4, 7, 'Minion', 'All these guys ever do is talk about the Thunder King. BOOOORRRINNG!', 'Neutral', 'Classic', 1, 'Mogu\'shan Warden', 'Taunt', NULL, 'Taunt', NULL),
('EX1_023', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_023.png', 4, 3, 'Minion', 'The first time they tried to guard Silvermoon against the scourge, it didn’t go so well…', 'Neutral', 'Classic', 3, 'Silvermoon Guardian', 'Divine Shield', NULL, 'DivineShield', NULL),
('EX1_043', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_043.png', 4, 1, 'Minion', 'Twilight drakes feed on Mystical Energy. And Tacos.', 'Neutral', 'Classic', 4, 'Twilight Drake', 'Battlecry: Gain +1 Health for each card in your hand.', NULL, NULL, '+1_Health_each_card'),
('EX1_005', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_005.png', 5, 2, 'Minion', 'Mere devilsaurs no longer excite him. Soon he\'ll be trying to catch Onyxia with only a dull Krol Blade.', 'Neutral', 'Classic', 4, 'Big game Hunter', 'Battlecry: Destroy a minion with 7 or more Attack.', NULL, NULL, 'kill_minion_7+_attack'),
('NEW1_024', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_024.png', 5, 4, 'Minion', 'He was this close to piloting a massive juggernaut into Stormwind Harbor. If it weren\'t for those pesky kids!', 'Neutral', 'Classic', 5, 'Captain Greenskin', 'Battlecry: Give your weapon +1/+1.', 'True', NULL, NULL),
('CS1_069', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS1_069.png', 5, 6, 'Minion', 'He used to be called Bog Beast, but it confused people because he wasn\'t an actual beast. Boom, New Name!', 'Neutral', 'Classic', 3, 'Fen Creeper', 'Taunt', NULL, 'Taunt', NULL),
('EX1_558', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_558.png', 5, 4, 'Minion', '“That belongs in the Hall of Explorers!”', 'Neutral', 'Classic', 5, 'Harrison Jones', 'Battlecry: Destroy your opponent\'s weapon and draw cards equal to its Durability.', 'True', NULL, NULL),
('CS2_221', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_221.png', 5, 6, 'Minion', 'She\'ll craft you a sword, but you\'ll need to bring her 5 Steel Ingots, 3 Motes of Earth, and the scalp of her last customer.', 'Neutral', 'Classic', 4, 'Spiteful Smith', 'Your weapon has +2 Attack while this is damaged.', NULL, NULL, NULL),
('NEW1_041', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_041.png', 5, 5, 'Minion', 'This Kodo is so big that he can stampede by himself.', 'Neutral', 'Classic', 3, 'Stampeding Kodo', 'Battlecry: Destroy a random enemy minion with 2 or less Attack.', NULL, NULL, 'Kill_minion_2-_Attack'),
('EX1_028', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_028.png', 5, 5, 'Minion', 'The wonderful thing about tigers is tigers are wonderful things!', 'Neutral', 'Classic', 5, 'Stranglethorn Tiger', 'Stealth', NULL, 'Stealth', NULL),
('EX1_583', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_583.png', 6, 4, 'Minion', 'If she threatens to \"moon\" you, it\'s not what you think.', 'Neutral', 'Classic', 5, 'Priestess of Elune', 'Battlecry: Restore 4 Health to your hero.', NULL, NULL, '+4_Health_hero'),
('EX1_033', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_033.png', 6, 5, 'Minion', 'Harpies are not pleasant sounding. That\'s the nicest I can put it.', 'Neutral', 'Classic', 4, 'Windfury Harpy', 'Windfury', NULL, 'Windfury', NULL),
('EX1_249', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_249.png', 7, 5, 'Minion', 'Baron Geddon was Ragnaros\'s foremost lieutenant, until he got FIRED.', 'Neutral', 'Classic', 7, 'Baron Geddon', 'At the end of your turn, deal 2 damage to ALL other characters.', 'True', NULL, '2_damage_all_other_end_turn'),
('CS2_161', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_161.png', 7, 5, 'Minion', 'Just mail him a package with a name and 10,000 gold. He\'ll take care of the rest.', 'Neutral', 'Classic', 7, 'Ravenholdt Assassin', 'Stealth', NULL, 'Stealth', NULL),
('NEW1_038', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_038.png', 8, 7, 'Minion', 'He\'s Gruul \"the Dragonkiller\". He just wanted to cuddle them… he never meant to…', 'Neutral', 'Classic', 7, 'Gruul', 'At the end of each turn, gain +1/+1 .', 'True', NULL, NULL),
('EX1_561', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_561.png', 9, 8, 'Minion', 'Alexstrasza the Life-Binder brings life and hope to everyone. Except Deathwing. And Malygos. And Nekros.', 'Neutral', 'Classic', 8, 'Alexstrasza', 'Battlecry: Set a hero\'s remaining Health to 15.', 'True', NULL, 'Health_hero_15'),
('EX1_543', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_543.png', 9, 8, 'Minion', 'The best defense against King Krush is to have someone you don’t like standing in front of you.', 'Hunter', 'Classic', 8, 'King Krush', 'Charge', 'True', 'Charge', NULL),
('EX1_563', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_563.png', 9, 12, 'Minion', 'Malygos hates it when mortals use magic. He gets so mad!', 'Neutral', 'Classic', 4, 'Malygos', 'Spell Damage +5', 'True', NULL, '+5_damage_spell'),
('EX1_560', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_560.png', 9, 8, 'Minion', 'Time to write some flavor text.', 'Neutral', 'Classic', 8, 'Nozdormu', 'Players only have 15 seconds to take their_turns.', 'True', NULL, NULL),
('EX1_586', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_586.png', 10, 8, 'Minion', 'See? Giant.', 'Neutral', 'Classic', 8, 'Sea Giant', 'Costs (1) less for each other minion on the battlefield.', NULL, NULL, NULL),
('GAME_002', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/GAME_002.png', 0, 1, 'Minion', NULL, 'Neutral', 'Basic', 1, 'Avatar of the Coin', 'You lost the coin flip, but gained a friend.', NULL, NULL, NULL),
('CS2_boar', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/CS2_boar.png', 1, 1, 'Minion', NULL, 'Neutral', 'Basic', 1, 'Boar', NULL, NULL, NULL, NULL),
('CS2_189', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_189.png', 1, 1, 'Minion', 'Don\'t bother asking her out on a date. She\'ll shoot you down.', 'Neutral', 'Basic', 1, 'Elven Archer', 'Battlecry: Deal 1 damage.', NULL, NULL, '1_damage'),
('CS1_042', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS1_042.png', 1, 2, 'Minion', 'If 1/2 minions are all that is defending Goldshire, you would think it would have been overrun years ago.', 'Neutral', 'Basic', 1, 'Goldshire Footman', 'Taunt', NULL, 'Taunt', NULL),
('EX1_508', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_508.png', 1, 1, 'Minion', 'These are the brainy murlocs. It turns out that doesn’t mean much.', 'Neutral', 'Basic', 1, 'Grimscale Oracle', 'Your other Murlocs have +1 Attack.', NULL, NULL, NULL),
('EX1_025t', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_025t.png', 1, 1, 'Minion', NULL, 'Neutral', 'Basic', 2, 'Mechanical Dragonling', NULL, NULL, NULL, NULL),
('CS2_168', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_168.png', 1, 1, 'Minion', 'Mrrraggglhlhghghlgh, mrgaaag blarrghlgaahahl mrgggg glhalhah a bghhll graggmgmg Garrosh mglhlhlh mrghlhlhl!!', 'Neutral', 'Basic', 2, 'Murloc Raider', NULL, NULL, NULL, NULL),
('EX1_506a', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_506a.png', 0, 1, 'Minion', NULL, 'Neutral', 'Basic', 1, 'Murloc Scout', NULL, NULL, NULL, NULL),
('CS2_tk1', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/CS2_tk1.png', 0, 1, 'Minion', NULL, 'Neutral', 'Basic', 1, 'Sheep', NULL, NULL, NULL, NULL),
('CS2_171', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_171.png', 1, 1, 'Minion', 'This card is boaring.', 'Neutral', 'Basic', 1, 'Stonetusk Boar', 'Charge', NULL, 'Charge', NULL),
('DS1_175', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_175.png', 1, 1, 'Minion', 'Other beasts totally dig hanging out with timber wolves.', 'Hunter', 'Basic', 1, 'Timber Wolf', 'Your other Beasts have +1_Attack.', NULL, NULL, NULL),
('EX1_011', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_011.png', 1, 1, 'Minion', 'Voodoo is an oft-misunderstood art. But it is art.', 'Neutral', 'Basic', 2, 'Voodoo Doctor', 'Battlecry: Restore 2_Health.', NULL, NULL, '+2_Health'),
('CS2_172', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_172.png', 2, 2, 'Minion', '\"Kill 30 raptors.\" - Hemet Nesingwary', 'Neutral', 'Basic', 3, 'Bloodfen Raptor', NULL, NULL, NULL, NULL),
('CS2_173', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_173.png', 2, 1, 'Minion', 'He just wants a hug. A sloppy... slimy... hug.', 'Neutral', 'Basic', 2, 'Bluegill Warrior', 'Charge', NULL, 'Charge', NULL),
('CS2_121', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_121.png', 2, 2, 'Minion', 'Grunting is what his father did and his father before that. It\'s more than just a job.', 'Neutral', 'Basic', 2, 'Frostwolf Grunt', 'Taunt', NULL, 'Taunt', NULL),
('CS2_142', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_142.png', 2, 2, 'Minion', 'In the old days, Kobolds were the finest candle merchants in the land. Then they got pushed too far...', 'Neutral', 'Basic', 2, 'Kobold Geomancer', 'Spell Damage +1', NULL, NULL, '+1_damage_spell'),
('EX1_015', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_015.png', 2, 1, 'Minion', '\"Half of this class will not graduate… since they\'ll have been turned to chickens.\" - Tinkmaster Overspark, teaching Gizmos 101.', 'Neutral', 'Basic', 1, 'Novice Engineer', 'Battlecry: Draw a card.', NULL, NULL, 'Draw_card'),
('CS2_120', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_120.png', 2, 3, 'Minion', 'Edward \"Lefty\" Smith tried to make luggage out of a river crocolisk once.', 'Neutral', 'Basic', 2, 'River Crocolisk', NULL, NULL, NULL, NULL),
('EX1_582', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_582.png', 3, 4, 'Minion', 'You don\'t see a lot of Dalaran warriors.', 'Neutral', 'Basic', 1, 'Dalaran Mage', 'Spell Damage +1', NULL, NULL, '+1_damage_spell'),
('NEW1_034', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/NEW1_034.png', 3, 2, 'Minion', NULL, 'Hunter', 'Basic', 4, 'Huffer', 'Charge', NULL, 'Charge', NULL),
('CS2_141', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_141.png', 3, 2, 'Minion', '\"Ready! Aim! Drink!\"', 'Neutral', 'Basic', 2, 'Ironforge Rifleman', 'Battlecry: Deal 1 damage.', NULL, NULL, '1_damage'),
('CS2_125', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_125.png', 3, 3, 'Minion', '\"Bear Carcass 1/10\"', 'Neutral', 'Basic', 3, 'Ironfur Grizzly', 'Taunt', NULL, 'Taunt', NULL),
('NEW1_033', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/NEW1_033.png', 3, 4, 'Minion', NULL, 'Hunter', 'Basic', 2, 'Leokk', 'Your other minions have +1 Attack.', NULL, NULL, NULL),
('CS2_118', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_118.png', 3, 1, 'Minion', 'He likes to think he is powerful, but pretty much anyone can solo Molten Core now.', 'Neutral', 'Basic', 5, 'Magma Rager', NULL, NULL, NULL, NULL),
('NEW1_032', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/NEW1_032.png', 3, 4, 'Minion', NULL, 'Hunter', 'Basic', 4, 'Misha', 'Taunt', NULL, 'Taunt', NULL),
('CS2_122', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_122.png', 3, 2, 'Minion', '\"That\'s a 50 DKP minus!\"', 'Neutral', 'Basic', 2, 'Raid Leader', 'Your other minions have +1 Attack.', NULL, NULL, NULL),
('EX1_019', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_019.png', 3, 2, 'Minion', 'They always have a spare flask of Sunwell Energy Drink™!', 'Neutral', 'Basic', 3, 'Shattered Sun Cleric', 'Battlecry: Give a friendly minion +1/+1.', NULL, NULL, NULL),
('CS2_127', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_127.png', 3, 4, 'Minion', 'He likes to act like he\'s in charge, but the silverback matriarch actually runs things.', 'Neutral', 'Basic', 1, 'Silverback Patriarch', 'Taunt', NULL, 'Taunt', NULL),
('CS2_124', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_124.png', 3, 1, 'Minion', 'Orcish raiders ride wolves because they are well adapted to harsh environments, and because they are soft and cuddly.', 'Neutral', 'Basic', 3, 'Wolfrider', 'Charge', NULL, 'Charge', NULL),
('CS2_182', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_182.png', 4, 5, 'Minion', 'He always dreamed of coming down from the mountains and opening a noodle shop, but he never got the nerve.', 'Neutral', 'Basic', 4, 'Chillwind Yeti', NULL, NULL, NULL, NULL),
('CS2_147', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_147.png', 4, 4, 'Minion', 'She\'s never quite sure what she\'s making, she just knows it\'s AWESOME!', 'Neutral', 'Basic', 2, 'Gnomish Inventor', 'Battlecry: Draw a card.', NULL, NULL, 'Draw_card'),
('CS2_119', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_119.png', 4, 7, 'Minion', 'His dreams of flying and breathing fire like his idol will never be realized.', 'Neutral', 'Basic', 2, 'Oasis Snapjaw', NULL, NULL, NULL, NULL),
('CS2_197', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_197.png', 4, 4, 'Minion', 'Training Ogres in the art of spellcasting is a questionable decision.', 'Neutral', 'Basic', 4, 'Ogre Magi', 'Spell Damage +1', NULL, NULL, '+1_damage_spell'),
('CS2_179', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_179.png', 4, 5, 'Minion', 'Sen\'jin Village is nice, if you like trolls and dust.', 'Neutral', 'Basic', 3, 'Sen\'jin Shieldmasta', 'Taunt', NULL, 'Taunt', NULL),
('CS2_131', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_131.png', 4, 5, 'Minion', 'They\'re still embarrassed about \"The Deathwing Incident\".', 'Neutral', 'Basic', 2, 'Stormwind Knight', 'Charge', NULL, 'Charge', NULL),
('CS2_187', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_187.png', 5, 4, 'Minion', 'You can hire him... until someone offers him enough gold to turn on you.', 'Neutral', 'Basic', 5, 'Booty Bay Bodyguard', 'Taunt', NULL, 'Taunt', NULL),
('DS1_055', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_055.png', 5, 5, 'Minion', 'Healing is just something she does in her free time. It\'s more of a hobby really.', 'Neutral', 'Basic', 4, 'Darkscale Healer', 'Battlecry: Restore 2 Health to all friendly characters.', NULL, NULL, '+2_Health_all_friendly'),
('CS2_226', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_226.png', 5, 4, 'Minion', 'The Frostwolves are locked in combat with the Stormpike Expedition over control of Alterac Valley. Every attempt at peace-talks has ended with Captain Galvangar killing the mediator.', 'Neutral', 'Basic', 4, 'Frostwolf Warlord', 'Battlecry: Gain +1/+1 for each other friendly minion on the battlefield.', NULL, NULL, '+1/+1_for_each_friendly_minion'),
('EX1_399', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_399.png', 5, 7, 'Minion', 'No Pain, No Gain.', 'Neutral', 'Basic', 2, 'Gurubashi Berserker', 'Whenever this minion takes damage, gain +3_Attack.', NULL, NULL, NULL),
('EX1_593', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_593.png', 5, 4, 'Minion', 'Your face is the place you\'d probably least like a dagger, and where rogues are most likely to deliver them.', 'Neutral', 'Basic', 4, 'Nightblade', 'Battlecry: Deal 3 damage to the enemy hero.', NULL, NULL, '3_damage_enemy_hero'),
('CS2_150', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_150.png', 5, 2, 'Minion', 'The Stormpike Commandos are demolition experts. They also bake a mean cupcake.', 'Neutral', 'Basic', 4, 'Stormpike Commando', 'Battlecry: Deal 2 damage.', NULL, NULL, '2_damage'),
('CS2_155', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_155.png', 6, 7, 'Minion', 'You earn the title of Archmage when you can destroy anyone who calls you on it.', 'Neutral', 'Basic', 4, 'Archmage', 'Spell Damage +1', NULL, NULL, '+1_damage_spell'),
('CS2_200', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_200.png', 6, 7, 'Minion', '\"ME HAVE GOOD STATS FOR THE COST\"', 'Neutral', 'Basic', 6, 'Boulderfist Ogre', NULL, NULL, NULL, NULL),
('CS2_162', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_162.png', 6, 5, 'Minion', 'He used to be a 2100+ rated arena player, but that was years ago and nobody can get him to shut up about it.', 'Neutral', 'Basic', 6, 'Lord of the Arena', 'Taunt', NULL, 'Taunt', NULL),
('CS2_213', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_213.png', 6, 2, 'Minion', 'One Insane Rocketeer. One Rocket full of Explosives. Infinite Fun.', 'Neutral', 'Basic', 5, 'Reckless Rocketeer', 'Charge', NULL, 'Charge', NULL),
('CS2_201', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_201.png', 7, 5, 'Minion', 'You don’t tame a Core Hound. You just train it to eat someone else before it eats you.', 'Neutral', 'Basic', 9, 'Core Hound', NULL, NULL, NULL, NULL),
('CS2_222', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_222.png', 7, 6, 'Minion', 'When Deathwing assaulted the capital, this soldier was the only member of his squad to survive. Now he\'s all bitter and stuff.', 'Neutral', 'Basic', 6, 'Stormwind Champion', 'Your other minions have +1/+1.', NULL, NULL, NULL),
('CS2_186', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_186.png', 7, 7, 'Minion', 'Golems are not afraid, but for some reason they still run when you cast Fear on them. Instinct, maybe? A desire to blend in?', 'Neutral', 'Basic', 7, 'War Golem', NULL, NULL, NULL, NULL),
('GVG_123', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/GVG_123.png', 3, 3, 'Minion', 'The inventor of the goblin shredder is involved in several patent disputes with the inventor of the soot spewer.', 'Mage', 'Goblins vs Gnomes', 3, 'Soot Spewer', '<b>Spell Damage +1</b>', NULL, NULL, '+1_damage_spell'),
('OG_120', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/OG_120.png', 8, 6, 'Minion', 'That\'s short for \"Anomnomnomnomalus\".', 'Mage', 'Whispers of the Old Gods', 8, 'Anomalus', '<b>Deathrattle:</b> Deal 8 damage to all minions.', 'True', NULL, NULL),
('OG_083', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/OG_083.png', 3, 2, 'Minion', 'Make sure you summon a Twilight Marshmallowcaller too! Mmmm Mmm Mmm!!', 'Mage', 'Whispers of the Old Gods', 2, 'Twilight Flamecaller', '<b>Battlecry:</b> Deal 1 damage to all enemy minions.', NULL, NULL, '1_damage_all_enemy_minion'),
('EX1_014t', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_014t.png', 1, NULL, 'Spell', NULL, 'Neutral', 'Classic', NULL, 'Bananas', 'Give a minion +1/+1.', NULL, NULL, '+1/+1'),
('EX1_617', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_617.png', 3, NULL, 'Spell', 'Accuracy is not a highly valued trait among the mok\'nathal. Deadliness is near the top, though.', 'Hunter', 'Classic', NULL, 'Deadly Shot', 'Destroy a random enemy minion.', NULL, NULL, 'kill_random_enemy_minion'),
('EX1_537', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_537.png', 5, NULL, 'Spell', 'Pull the pin, count to 5, then shoot. Then duck.', 'Hunter', 'Classic', NULL, 'Explosive Shot', 'Deal $5 damage to a minion and $2 damage to adjacent ones.', NULL, NULL, '5_damage_2_damage_adjecent'),
('EX1_279', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_279.png', 10, NULL, 'Spell', 'Take the time for an evil laugh after you draw this card.', 'Mage', 'Classic', NULL, 'Pyroblast', 'Deal $10 damage.', NULL, NULL, '10_damage'),
('GAME_005', 'http://wow.zamimg.com/images/hearthstone/cards/enus/original/GAME_005.png', 0, NULL, 'Spell', NULL, 'Neutral', 'Basic', NULL, 'The Coin', 'Gain 1 Mana Crystal this turn only.', NULL, NULL, '+1_mana_this_turn'),
('EX1_277', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_277.png', 1, NULL, 'Spell', 'You\'d think you\'d be able to control your missiles a little better since you\'re a powerful mage and all.', 'Mage', 'Basic', NULL, 'Arcane Missiles', 'Deal $3 damage randomly split among all enemies.', NULL, NULL, '3_damage_split_enemy'),
('DS1_185', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_185.png', 1, NULL, 'Spell', 'Magi conjured arcane arrows to sell to hunters, until hunters learned just enough magic to do it themselves. The resulting loss of jobs sent Stormwind into a minor recession.', 'Hunter', 'Basic', NULL, 'Arcane Shot', 'Deal $2 damage.', NULL, NULL, '2_damage'),
('CS2_084', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_084.png', 1, NULL, 'Spell', 'Never play \'Hide and Go Seek\' with a Hunter.', 'Hunter', 'Basic', NULL, 'Hunter\'s Mark', 'Change a minion\'s Health to 1.', NULL, NULL, 'Health_1_enemy_minion'),
('CS2_025', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_025.png', 2, NULL, 'Spell', 'This spell is much better than Arcane Implosion.', 'Mage', 'Basic', NULL, 'Arcane Explosion', 'Deal $1 damage to all enemy minions.', NULL, NULL, '1_damage_all_enemy_minion'),
('CS2_023', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_023.png', 3, NULL, 'Spell', 'Playing this card makes you SMARTER. And let\'s face it: we could all stand to be a little smarter.', 'Mage', 'Basic', NULL, 'Arcane Intellect', 'Draw 2 cards.', NULL, NULL, 'Draw_2_card'),
('CS2_029', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_029.png', 4, NULL, 'Spell', 'This spell is useful for burning things. If you\'re looking for spells that toast things, or just warm them a little, you\'re in the wrong place.', 'Mage', 'Basic', NULL, 'Fireball', 'Deal $6 damage.', NULL, NULL, '6_damage'),
('DS1_183', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_183.png', 4, NULL, 'Spell', 'You see, it\'s all about throughput.', 'Hunter', 'Basic', NULL, 'Multi-Shot', 'Deal $3 damage to two random enemy minions.', NULL, NULL, '3_damage_2_random_enemy_minion'),
('CS2_022', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_022.png', 4, NULL, 'Spell', 'There was going to be a pun in this flavor text, but it just came out baa-d.', 'Mage', 'Basic', NULL, 'Polymorph', 'Transform a minion\ninto a 1/1 Sheep.', NULL, NULL, 'sheep'),
('CS2_032', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_032.png', 7, NULL, 'Spell', 'When the ground is on fire, you should not stop, drop, and roll.', 'Mage', 'Basic', NULL, 'Flamestrike', 'Deal $4 damage to all enemy minions.', NULL, NULL, '4_damage_all_enemy_minion'),
('EX1_162', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_162.png', 2, 2, 'Minion', 'We are pretty excited about the upcoming release of Dire Wolf Beta, just repost this sign for a chance at a key.', 'Neutral', 'Classic', 2, 'Dire Wolf Alpha', 'Adjacent minions have +1_Attack.', NULL, NULL, NULL),
('EX1_058', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_058.png', 2, 3, 'Minion', 'She carries a shield, but only so she can give it to someone she can stand behind.', 'Neutral', 'Classic', 2, 'Sunfury Protector', 'Battlecry: Give adjacent minions Taunt.', NULL, NULL, NULL),
('EX1_590', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_590.png', 3, 3, 'Minion', 'The Blood Knights get their holy powers from the Sunwell, which you should NOT bathe in.', 'Neutral', 'Classic', 3, 'Blood Knight', 'Battlecry: All minions lose Divine Shield. Gain +3/+3 for each Shield lost.', NULL, NULL, NULL),
('CS2_203', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_203.png', 3, 1, 'Minion', 'Their wings are silent but their screech is... whatever the opposite of silent is.', 'Neutral', 'Classic', 2, 'Ironbeak Owl', 'Battlecry: Silence a_minion.', NULL, NULL, 'Silence'),
('EX1_584', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_584.png', 4, 5, 'Minion', 'Sometimes he forgets and just wanders into someone else\'s game.', 'Neutral', 'Classic', 2, 'Ancient Mage', 'Battlecry: Give adjacent_minions Spell_Damage +1.', NULL, NULL, NULL),
('EX1_093', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_093.png', 4, 3, 'Minion', 'You wouldn’t think that Argus would need this much defending. But it does.', 'Neutral', 'Classic', 2, 'Defender of Argus', 'Battlecry: Give adjacent minions +1/+1 and Taunt.', NULL, NULL, NULL),
('EX1_048', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_048.png', 4, 3, 'Minion', 'Spellbreakers can rip enchantments from magic-wielders. The process is painless and can be performed on an outpatient basis.', 'Neutral', 'Classic', 4, 'Spellbreaker', 'Battlecry: Silence a_minion.', NULL, NULL, 'Silence'),
('EX1_097', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_097.png', 5, 4, 'Minion', 'Abominations enjoy Fresh Meat and long walks on the beach.', 'Neutral', 'Classic', 4, 'Abomination', 'Taunt. Deathrattle: Deal 2\ndamage to ALL characters.', NULL, 'Taunt', NULL),
('EX1_067', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_067.png', 6, 2, 'Minion', 'The Argent Dawn stands vigilant against the Scourge, as well as people who cut in line at coffee shops.', 'Neutral', 'Classic', 4, 'Argent Commander', 'Charge\nDivine Shield', NULL, 'Charge', NULL),
('EX1_032', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_032.png', 6, 5, 'Minion', 'She doesn’t ACTUALLY walk on the Sun. It\'s just a name. Don’t worry!', 'Neutral', 'Classic', 4, 'Sunwalker', 'Taunt\nDivine Shield', NULL, 'Taunt', NULL),
('EX1_002', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_002.png', 6, 5, 'Minion', 'He was sent by the Lich King to disrupt the Argent Tournament. We can pretty much mark that a failure.', 'Neutral', 'Classic', 4, 'The Black Knight', 'Battlecry: Destroy an enemy minion with Taunt.', 'True', NULL, 'kill_enemy_taunt'),
('DS1_070', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_070.png', 4, 3, 'Minion', '\"Who let the dogs out?\" he asks. It\'s rhetorical.', 'Hunter', 'Basic', 4, 'Houndmaster', 'Battlecry: Give a friendly Beast +2/+2 and Taunt.', NULL, NULL, NULL),
('DS1_178', 'http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_178.png', 5, 5, 'Minion', 'Tundra rhinos are often mistaken for kodos. Or am I mistaken?', 'Hunter', 'Basic', 2, 'Tundra Rhino', 'Your Beasts have Charge.', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cardsindeck`
--

DROP TABLE IF EXISTS `cardsindeck`;
CREATE TABLE IF NOT EXISTS `cardsindeck` (
  `deckId` varchar(20) NOT NULL,
  `cardId` varchar(10) NOT NULL,
  KEY `fk_cardid_cardsindeck` (`cardId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `cardsindeck`
--

INSERT INTO `cardsindeck` (`deckId`, `cardId`) VALUES
('HD_01', 'EX1_033'),
('HD_01', 'EX1_033'),
('HD_01', 'EX1_023'),
('HD_01', 'EX1_023'),
('HD_01', 'EX1_020'),
('HD_01', 'EX1_020'),
('HD_01', 'EX1_021'),
('HD_01', 'EX1_170'),
('HD_01', 'EX1_170'),
('HD_01', 'EX1_021'),
('HD_01', 'EX1_010'),
('HD_01', 'EX1_010'),
('HD_01', 'EX1_017'),
('HD_01', 'EX1_017'),
('HD_01', 'CS2_169'),
('HD_01', 'EX1_028'),
('HD_01', 'CS2_169'),
('HD_01', 'EX1_405'),
('HD_01', 'CS1_042'),
('HD_01', 'EX1_405'),
('HD_01', 'EX1_028'),
('HD_01', 'DS1_070'),
('HD_01', 'DS1_183'),
('HD_01', 'NEW1_034'),
('HD_01', 'NEW1_033'),
('HD_01', 'NEW1_034'),
('HD_01', 'NEW1_032'),
('HD_01', 'NEW1_032'),
('HD_01', 'EX1_538t'),
('HD_01', 'EX1_538t'),
('HD_02', 'CS2_084'),
('HD_02', 'CS2_152'),
('HD_02', 'CS2_169'),
('HD_02', 'DS1_070'),
('HD_02', 'DS1_175'),
('HD_02', 'DS1_178'),
('HD_02', 'DS1_183'),
('HD_02', 'DS1_185'),
('HD_02', 'EX1_004'),
('HD_02', 'EX1_008'),
('HD_02', 'EX1_010'),
('HD_02', 'EX1_029'),
('HD_02', 'EX1_049'),
('HD_02', 'EX1_059'),
('HD_02', 'EX1_082'),
('HD_02', 'EX1_096'),
('HD_02', 'EX1_393'),
('HD_02', 'EX1_405'),
('HD_02', 'EX1_537'),
('HD_02', 'EX1_538t'),
('HD_02', 'EX1_543'),
('HD_02', 'EX1_617'),
('HD_02', 'NEW1_017'),
('HD_02', 'NEW1_018'),
('HD_02', 'NEW1_023'),
('HD_02', 'NEW1_032'),
('HD_02', 'NEW1_033'),
('HD_02', 'NEW1_034'),
('HD_02', 'NEW1_037'),
('HD_02', 'NEW1_0402'),
('HD_03', 'CS2_084'),
('HD_03', 'CS2_152'),
('HD_03', 'CS2_169'),
('HD_03', 'DS1_070'),
('HD_03', 'DS1_175'),
('HD_03', 'DS1_178'),
('HD_03', 'DS1_183'),
('HD_03', 'DS1_185'),
('HD_03', 'EX1_004'),
('HD_03', 'EX1_008'),
('HD_03', 'EX1_010'),
('HD_03', 'EX1_029'),
('HD_03', 'EX1_049'),
('HD_03', 'EX1_059'),
('HD_03', 'EX1_082'),
('HD_03', 'EX1_096'),
('HD_03', 'EX1_393'),
('HD_03', 'EX1_405'),
('HD_03', 'EX1_537'),
('HD_03', 'EX1_538t'),
('HD_03', 'EX1_543'),
('HD_03', 'EX1_617'),
('HD_03', 'NEW1_017'),
('HD_03', 'NEW1_018'),
('HD_03', 'NEW1_023'),
('HD_03', 'NEW1_032'),
('HD_03', 'NEW1_033'),
('HD_03', 'NEW1_034'),
('HD_03', 'NEW1_037'),
('HD_03', 'NEW1_0402'),
('MD_01', 'EX1_563'),
('MD_01', 'EX1_561'),
('MD_01', 'EX1_563'),
('MD_01', 'EX1_560'),
('MD_01', 'EX1_249'),
('MD_01', 'EX1_249'),
('MD_01', 'EX1_097'),
('MD_01', 'EX1_097'),
('MD_01', 'EX1_593'),
('MD_01', 'EX1_593'),
('MD_01', 'EX1_017'),
('MD_01', 'NEW1_040t'),
('MD_01', 'CS2_121'),
('MD_01', 'EX1_096'),
('MD_01', 'NEW1_040t'),
('MD_01', 'EX1_082'),
('MD_01', 'EX1_082'),
('MD_01', 'EX1_032'),
('MD_01', 'EX1_032'),
('MD_01', 'EX1_067'),
('MD_01', 'EX1_067'),
('MD_01', 'EX1_010'),
('MD_01', 'EX1_008'),
('MD_01', 'OG_120'),
('MD_01', 'OG_120'),
('MD_01', 'EX1_008'),
('MD_01', 'EX1_008'),
('MD_02', 'CS2_022'),
('MD_02', 'CS2_023'),
('MD_02', 'CS2_025'),
('MD_02', 'CS2_029'),
('MD_02', 'CS2_032'),
('MD_02', 'CS2_152'),
('MD_02', 'CS2_169'),
('MD_02', 'CS2_188'),
('MD_02', 'CS2_231'),
('MD_02', 'EX1_004'),
('MD_02', 'EX1_008'),
('MD_02', 'EX1_009'),
('MD_02', 'EX1_010'),
('MD_02', 'EX1_029'),
('MD_02', 'EX1_049'),
('MD_02', 'EX1_059'),
('MD_02', 'EX1_082'),
('MD_02', 'EX1_096'),
('MD_02', 'EX1_277'),
('MD_02', 'EX1_279'),
('MD_02', 'EX1_393'),
('MD_02', 'EX1_405'),
('MD_02', 'GVG_123'),
('MD_02', 'NEW1_017'),
('MD_02', 'NEW1_018'),
('MD_02', 'NEW1_023'),
('MD_02', 'NEW1_037'),
('MD_02', 'NEW1_040t'),
('MD_02', 'OG_083'),
('MD_02', 'OG_120'),
('MD_03', 'CS2_022'),
('MD_03', 'CS2_023'),
('MD_03', 'CS2_025'),
('MD_03', 'CS2_029'),
('MD_03', 'CS2_032'),
('MD_03', 'CS2_152'),
('MD_03', 'CS2_169'),
('MD_03', 'CS2_188'),
('MD_03', 'CS2_231'),
('MD_03', 'EX1_004'),
('MD_03', 'EX1_008'),
('MD_03', 'EX1_009'),
('MD_03', 'EX1_010'),
('MD_03', 'EX1_029'),
('MD_03', 'EX1_049'),
('MD_03', 'EX1_059'),
('MD_03', 'EX1_082'),
('MD_03', 'EX1_096'),
('MD_03', 'EX1_277'),
('MD_03', 'EX1_279'),
('MD_03', 'EX1_393'),
('MD_03', 'EX1_405'),
('MD_03', 'GVG_123'),
('MD_03', 'NEW1_017'),
('MD_03', 'NEW1_018'),
('MD_03', 'NEW1_023'),
('MD_03', 'NEW1_037'),
('MD_03', 'NEW1_040t'),
('MD_03', 'OG_083'),
('MD_03', 'OG_120'),
('MD_01', 'EX1_008'),
('MD_01', 'EX1_560'),
('MD_01', 'EX1_010');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `decks`
--

DROP TABLE IF EXISTS `decks`;
CREATE TABLE IF NOT EXISTS `decks` (
  `deckId` varchar(20) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `class` varchar(80) DEFAULT NULL,
  `defaultDeck` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`deckId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `decks`
--

INSERT INTO `decks` (`deckId`, `name`, `class`, `defaultDeck`) VALUES
('HD_01', 'Deck A', 'Hunter', 'True'),
('HD_02', 'Deck B', 'Hunter', 'False'),
('HD_03', 'Deck C', 'Hunter', 'False'),
('MD_01', 'Deck A', 'Mage', 'True'),
('MD_02', 'Deck B', 'Mage', 'False'),
('MD_03', 'Deck C', 'Mage', 'False');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `playercardsindeck`
--

DROP TABLE IF EXISTS `playercardsindeck`;
CREATE TABLE IF NOT EXISTS `playercardsindeck` (
  `cardId` varchar(20) NOT NULL,
  `playerName` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `playercardsinhand`
--

DROP TABLE IF EXISTS `playercardsinhand`;
CREATE TABLE IF NOT EXISTS `playercardsinhand` (
  `cardId` varchar(20) NOT NULL,
  `playerName` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `playercardsonfield`
--

DROP TABLE IF EXISTS `playercardsonfield`;
CREATE TABLE IF NOT EXISTS `playercardsonfield` (
  `cardId` varchar(20) NOT NULL,
  `playerName` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
