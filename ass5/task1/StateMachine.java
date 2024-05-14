package task1;
import java.util.Scanner;

public class StateMachine {
    State current = new pirates_island();
    boolean reached_treasure = false;
    island_index[] path = {island_index.PIRATES_ISLAND};

    public enum island_index {
        MUSKET_HILL,
        PIRATES_ISLAND,
        SHIPWRECK_BAY,
        MUTINEERS_ISLAND,
        DEAD_MANS_ISLAND,
        SMUGGLERS_COVE,
        TREASURE_ISLAND
    }

    public String name_of_indexed_island(island_index id){
        switch (id) {
            case MUSKET_HILL:
                return "Musket Hill";
            case PIRATES_ISLAND:
                return "Pirates' Island";
            case SHIPWRECK_BAY: 
                return "Shipwreck Bay";
            case MUTINEERS_ISLAND:
                return "Multineers' Island";
            case DEAD_MANS_ISLAND:
                return "Dead Man's Island";
            case SMUGGLERS_COVE:
                return "Smugglers' Cove";
            case TREASURE_ISLAND:
                return "Treasure Island";
            default:
                return "no such Island";
        }
    }

    public island_index island_index_from_name(String name){
        if (name.equals("Musket Hill")) return island_index.MUSKET_HILL;
        if (name.equals("Pirates' Island")) return island_index.PIRATES_ISLAND;
        if (name.equals("Shipwreck Bay")) return island_index.SHIPWRECK_BAY;
        if (name.equals("Multineers' Island")) return island_index.MUTINEERS_ISLAND;
        if (name.equals("Dead Man's Island")) return island_index.DEAD_MANS_ISLAND;
        if (name.equals("Smugglers' Cave")) return island_index.SMUGGLERS_COVE;
        if (name.equals("Treasure Island")) return island_index.TREASURE_ISLAND;
        System.out.println("no island with name: " + name);
        System.exit(0);
        return null;
    }

    public static void main(String[] args) {
        StateMachine sm = new StateMachine();
        Scanner s = new Scanner(System.in);
        String input = "";
        while (true) {
            if (sm.reached_treasure) {
                String final_path = "";
                for(int n = 0; n < sm.path.length; n++) {
                    if (n + 1 == sm.path.length) {
                        final_path += sm.name_of_indexed_island(sm.path[n]);
                    } else {
                        final_path += sm.name_of_indexed_island(sm.path[n]) + " -> ";
                    }
                    
                }
                System.out.println(final_path);
                s.close();
                return;
            }
            System.out.println(sm.current.info());
            input = s.nextLine();
            switch (input.charAt(0)) {
                case 'A':
                    sm.current = sm.current.transition(Action.A);
                    break;
                case 'B':
                    sm.current = sm.current.transition(Action.B);
                    break;
                default:
                    System.out.println("incorrect input");
                    continue;
            }
            island_index[] new_path = new island_index[sm.path.length + 1];
            for (int n = 0; n < sm.path.length; n++) {
                new_path[n] = sm.path[n];
            }

            new_path[sm.path.length] = sm.island_index_from_name(sm.current.str());
            sm.path = new_path;

            if (sm.current.str().equals("Treasure Island")) sm.reached_treasure = true;
        }
    }
}
