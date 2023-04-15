#include "Game_token.h"

namespace Grid_game {

   // for each direction check that the space were moving is valid. Then modify x / y position
   // apply_terrain_effect and pp are taken care of in Token_base::step_normal()
   void Token::move(direction dir) {
      switch(dir) {
         case direction::up:
            if(((y-1) >= 0) && board.retrieve_space(x, y-1).type() != Space::barrier) {
               y--;
            }
            break;
         case direction::down:
            if(((y+1) < board.height()) && board.retrieve_space(x, y+1).type() != Space::barrier) {
               y++;
            }
            
            break;
         case direction::left:
            if(((x-1) >= 0) && board.retrieve_space(x-1, y).type() != Space::barrier) {
               x--;
            }
            break;
         case direction::right:
            if(((x+1) < board.width()) && board.retrieve_space(x+1, y).type() != Space::barrier) {
               x++;
            }
            break;
         default:
            break;
      }
   }

   // token has no special move. Regular move first value of dirs
   void Token::move_special(vector<direction> dirs) {
      move(dirs[0]);
   }

   // modify hp by terrain effect
   void Token::apply_terrain_effect(const Space::terrain_type t) {
      switch(t) {
         case Space::water:
            hp--;
            break;
         case Space::lava:
            hp = 0;
            break;
         default:
            break;
      }
   }
}
