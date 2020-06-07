/**
 * Time complexity : O(n)
 * Space complexity : O(n)
 * @param {number} N
 * @return {number}
 */
var bitwiseComplement = function (N) {
  const binary = N.toString(2);
  let complementOfBinary = '';

  for (let i = 0; i < binary.length; ++i) {
    if (binary[i] == '0') {
      complementOfBinary += '1';
    } else {
      complementOfBinary += '0';
    }
  }
  return parseInt(complementOfBinary, 2);
};
