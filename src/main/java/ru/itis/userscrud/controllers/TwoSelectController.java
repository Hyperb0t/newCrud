package ru.itis.userscrud.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Controller
public class TwoSelectController {

    private String[] laptops = "ABS - ABS,Acer - TravelMate, Extensa, Acer Note,Adamant - Adamant, CTX,Apple - PowerBook, iMac,ARM - ARM,Asus - Asus, Grandio, RoverBook,AST - Ascentia,Axis - Infinium,Brick - ThunderBrick, ThinBrick, NoteBrick,BSI - BSI,Clevo - Clevo,Chem Usa - ChemBook,Compaq - Presario, Prosignia, Armada,Digital Hi Note, Contura, Elite,CompUsa - AmeriNote,DELL - Inspiron, Latitude,FIC - тайваньский производитель ОЕМ - ноутбуков Leo Design, Leo, RoverBook,Fujitsu - LifeBook, Biblo, Milan,Fujitsu Siemens в России,FutureTech - FutureMate,Gateway - Solo,GVC - тайваньский производитель ОЕМ - ноутбуков aka ROVERBook,Hewlett Packard - OmniBook, Pavilion,IBM - ThinkPad,Inventec - производитель ОЕМ - ноутбуков,Kapok - Ultimate, RoverBook,MAG - Verity, TinyNote,Mars- MarsPal,Micron- TransPort,Mitac -MiNote, RoverBook,Mitsubishi - AMiTY, Pedion,NEC - Versa,Panasonic - ToughBook,ProStar - ProStar,Quantex - Quantex,Ricoh - Magio,Samsung - Sens,Sager - Sager,Sharp - Actius,Siemens - LifeBook, Scenic,Spectec - производитель Bare Bone, в частности, для HP,Sony - VAIO,Toshiba - Тесra, Libretto, Portege, Satellite, Satellite Pro,TwinHead - PowerSlim, SlimNote,Windrover - Compass, Navigator,WinBook - WinBook".split(",");
    private String[] cars = "Acura,Alfa Romeo,Aston Martin,Audi,Bentley,BMW,Brilliance,Buick,BYD,Cadillac,Changan,Chery,Chevrolet,Chrysler,Citroen,Daewoo,Daihatsu,Datsun,Dodge,Dongfeng,FAW,Ferrari,Fiat,Ford,GAZ,Geely,Genesis,GMC,Great Wall,Haval,Holden,Honda,Hummer,Hyundai,Infiniti,Isuzu,Iveco,Jaguar,Jeep,Kia,Lamborghini,Lancia,Land Rover,Lexus,Lifan,Lincoln,Lotus,Marussia,Maserati,Maybach,Mazda,McLaren,Mercedes,Mercury,MG,Mini,Mitsubishi,Nissan,Opel,Peugeot,Plymouth,Pontiac,Porsche,Ravon,Renault,Rolls-Royce,Rover,Saab,Saturn,Scion,Seat,Skoda,Smart,Ssang Yong,Subaru,Suzuki,Tesla,Toyota,UAZ,VAZ,Volkswagen,Volvo".split(",");
    private Map<String, List<String>> options = new HashMap<>();
    {
        options.put("cars", Arrays.asList(cars));
        options.put("laptops", Arrays.asList(laptops));
    }

    @GetMapping("/2select")
    public String getPage() {
        return "2select";
    }

    @GetMapping(value = "/2options", produces = "application/json")
    @ResponseBody
    public List<String> getSecondOptions(@Param("firstSelect") String firstSelect) {
        if (options.containsKey(firstSelect)) {
//            System.out.println("returning " + options.get(firstSelect));
            return options.get(firstSelect);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "wrong first option");
        }
    }
}
