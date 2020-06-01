/**
 * Time complexity : O(n)
 * Space complexity : O(1)
 * @param {number[][]} coordinates
 * @return {boolean}
 */
var checkStraightLine = function (coordinates) {
  if (coordinates.length < 3) {
    return true;
  } else {
    // calculate slope
    const [x1, y1] = coordinates[0];
    const [x2, y2] = coordinates[1];
    const slope = (y2 - y1) / (x2 - x1);
    //check if vertical line
    if (slope === Infinity) {
        for (let i = 2; i < coordinates.length; ++i) {
          const [x] = coordinates[i];
          if (x !== x1) {
            return false;
          }
        }
        return true;
    } else {
      for (let i = 2; i < coordinates.length; ++i) {
        const [prevX, prevY] = coordinates[i - 1];
        const [x, y] = coordinates[i];
        const currSlope = (y - prevY) / (x - prevX);
        if (currSlope !== slope) return false;
      }
      return true;
    }
  }
};
;
