const allConstruct = (target, wordBank, memo={}) => {
    if(target in memo)  return memo[target];
    if(target === '') return [[]];
    let result = [];
    for (let word of wordBank) {
        if(target.startsWith(word)){
           const suffix = target.slice(word.length)
           const suffixWays = allConstruct(suffix, wordBank, memo);
           const targetWays = suffixWays.map(way => [word, ...way])
           result.push(...targetWays)
        }
    }
    memo[target] = result;
    return memo[target];
}

console.log(allConstruct('purple', ['purp', 'p', 'ur', 'le', 'purpl']))
console.log(allConstruct('abcdef', ['ab', 'abc', 'cd', 'def', 'abcd', 'ef', 'c']))
console.log(allConstruct('impossible', ['ab', 'abc', 'cd', 'def', 'abcd']))
console.log(allConstruct('eeeeeeeeeeeeeeeeee', ['e', 'ee', 'eee', 'eeee', 'eeeee','eeeeee','te','bo']))
console.log(allConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeef', ['e', 'ee', 'eee', 'eeee', 'eeeee','eeeeee','te','bo']))
//console.log(allConstruct('skateabcdefg', ['ab', 'abc', 'cd', 'def', 'abcd','ska','te','bo']))
//console.log(allConstruct('enterapotentpot', ['a', 'p', 'ent', 'enter', 'ot','o','t']))
////console.log(allConstruct('eeeeeeeeeeeeef', ['e', 'ee', 'eee', 'eeee', 'eeeee','eeeeee','te','bo']))
////console.log(allConstruct('eeeeeeeeeeeeeeee', ['e', 'ee', 'eee', 'eeee', 'eeeee','eeeeee','te','bo']))
//